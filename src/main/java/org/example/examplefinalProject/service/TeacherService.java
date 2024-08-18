package org.example.examplefinalProject.service;

import lombok.RequiredArgsConstructor;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Teacher;
import org.example.examplefinalProject.exception.InvalidParamsException;
import org.example.examplefinalProject.repository.ClassRoomRepository;
import org.example.examplefinalProject.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final ClassRoomRepository classRoomRepository;

    private final TeacherRepository teacherRepository;


    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Integer teacherId) {
        return teacherRepository.findById(teacherId).orElse(null);
    }

    public Teacher createTeacher(String teacherName, String teacherSurname, String classRoomName){

        ClassRoom classRoom = classRoomRepository.findByClassRoomName(classRoomName);

        Teacher teacher = Teacher.builder()
                .teacherName(teacherName)
                .teacherSurname(teacherSurname)
                .classRoom(classRoom)
                .build();
        if (teacherName == null || teacherSurname == null){
            throw new InvalidParamsException("TeacherName or teacherSurname is not null ");
        }
        // ulozenim noveho teachera do db ziskame jeho id
        Teacher savedTeacher = teacherRepository.save(teacher);

        // toto je pro uložení učitele (teacher_id) do classRoomy
        classRoom.setClassTeacher(savedTeacher);

        // ulozime classroom s teacher_id
        classRoomRepository.save(classRoom);

        return savedTeacher;
    }

    public void deleteTeacher(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);

        if (teacher.isPresent() && teacher.get().getClassRoom() != null) {
            ClassRoom classRoom = classRoomRepository.findByClassRoomId(teacher.get().getClassRoom().getClassRoomId());
            classRoom.setClassTeacher(null);
            classRoomRepository.save(classRoom);
        }
        teacherRepository.deleteById(id);
    }
}

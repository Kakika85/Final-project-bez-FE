package org.example.examplefinalProject.service;

import lombok.RequiredArgsConstructor;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Teacher;
import org.example.examplefinalProject.exception.InvalidParamsException;
import org.example.examplefinalProject.repository.ClassRoomRepository;
import org.example.examplefinalProject.repository.StudentRepository;
import org.example.examplefinalProject.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ClassRoomService {

    private final ClassRoomRepository classRoomRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final TeacherService teacherService;

    /**
     * Vrací seznam všech tříd.
     *
     * @return Seznam tříd.
     */
    public List<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    /**
     * Vrací detail třídy.
     *
     // @param id Identifikátor třídy.
     * @return Detail třídy nebo {@code null}.
     */
    public ClassRoom findById(int classRoomId) {
        return classRoomRepository.findById(classRoomId).orElse(null);
    }

    /**
     * Vrací počet studentů v dané třídě.
     *
     // @param id Identifikátor třídy.
     * @return Počet studentů.
     */
    public int studentCountById(int classRoomId) {
        return studentRepository.countByClassRoomClassRoomId(classRoomId);
    }

    public void createClassRoom(String classRoomName, String teacherFullName) {
        if (classRoomName == null) {
            throw new InvalidParamsException("ClassRoomName is null ");
        }

        Optional<Teacher> teacher = Optional.empty();
        String[] teacherNameParts = teacherFullName.split(" ");
        if (teacherNameParts.length >= 2) {
            teacher = teacherRepository.findByTeacherNameAndTeacherSurname(teacherNameParts[0], teacherNameParts[1]);
            if (teacher.isEmpty()) {
                teacher = Optional.of(teacherService.createTeacher(teacherNameParts[0], teacherNameParts[1], classRoomName));
            }
        }

        ClassRoom classRoom = ClassRoom.builder()
                .classRoomName(classRoomName)
                .classTeacher(teacher.orElse(null))
                .build();
        classRoomRepository.save(classRoom);
    }

    public void deleteClassRoom(Integer classRoomId) {
        studentRepository.deleteById(classRoomId);
        classRoomRepository.deleteById(classRoomId);
    }
}
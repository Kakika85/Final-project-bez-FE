package org.example.examplefinalProject.service;

import ch.qos.logback.core.model.Model;
import lombok.Builder;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.exception.ClassRoomNotFoundException;
import org.example.examplefinalProject.repository.ClassRoomRepository;
import org.example.examplefinalProject.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@Builder
public class StudentService {
    private final StudentRepository studentRepository;
    private final ClassRoomRepository classRoomRepository;

    public StudentService(StudentRepository studentRepository, ClassRoomRepository classRoomRepository) {
        this.studentRepository = studentRepository;
        this.classRoomRepository = classRoomRepository;
    }

    // potřeba pro combo box
    public List<Student> searchByQuery(String query) {
        return studentRepository.findByStudentNameContainingIgnoreCase(query);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void createStudent(String studentName, String studentSurname, String classRoomName) {

        ClassRoom classRoom = classRoomRepository.findByClassRoomName(classRoomName);
        if (classRoom == null) {
            throw new ClassRoomNotFoundException("Class with name '" + classRoomName + "' was not found.");
        }
        Student student = Student.builder()
                .studentName(studentName)
                .studentSurname(studentSurname)
                .classRoom(classRoom)
                .build();

        studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}

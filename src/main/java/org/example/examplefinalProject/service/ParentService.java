package org.example.examplefinalProject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Parent;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.entity.Teacher;
import org.example.examplefinalProject.exception.InvalidParamsException;
import org.example.examplefinalProject.exception.InvalidStatusException;
import org.example.examplefinalProject.exception.ParentNotFoundExeption;
import org.example.examplefinalProject.repository.ParentRepository;
import org.example.examplefinalProject.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParentService {

    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;

    public List<Parent> findAll() {
        return parentRepository.findAll();
    }

    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public Parent findById(Integer parentId) {
        return parentRepository.findById(parentId).orElse(null);
    }

    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void createParent(String parentName, String parentSurname, String parentEmail, String parentPhone, String studentFullName) {

        String[] studentNameParts = studentFullName.split(" ");

        Student student = studentRepository.findByStudentNameAndStudentSurname(studentNameParts[0], studentNameParts[1]);

        Parent parent = Parent.builder()
                .parentName(parentName)
                .parentSurname(parentSurname)
                .parentEmail(parentEmail)
                .parentPhone(parentPhone)
                .children(Collections.singletonList(student))
                .build();
        if (parentName == null || parentSurname == null) {
            throw new InvalidParamsException("ParentName or parentSurname is not null ");
        }
        parentRepository.save(parent);
    }

    public void deleteParent(Integer parentId) {
        parentRepository.deleteById(parentId);
    }
}

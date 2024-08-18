package org.example.examplefinalProject.service;

import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

//    @Mock
//    private StudentRepository studentRepository;
//
//    @InjectMocks
//    private StudentService studentService;
//
//    private Student student1;
//    private Student student2;
//
//    @BeforeEach
////    void setUp() {
////        student1 = new Student();
////        student1.setStudentId(1);
////        student1.setStudentName("Tomáš Maný");
////
////        student2 = new Student();
////        student2.setStudentId(2);
////        student2.setStudentName("Kleopatra Mrtvá");
////    }
//
//    @Test
//    void testFindAll() {
//        List<Student> students = Arrays.asList(student1, student2);
//        when(studentRepository.findAll()).thenReturn(students);
//
//        List<Student> result = studentService.findAll();
//
//        assertEquals(2, result.size());
//        assertEquals("Tomáš Marný", result.get(0).getStudentName());
//        assertEquals("Kleopatra Mrtvá", result.get(1).getStudentName());
//    }
//
//    @Test
//    void testFindById_existingId() {
//        when(studentRepository.findById(2)).thenReturn(Optional.of(student2));
//
//        Student result = studentService.findById(2);
//
//        assertEquals("Kleopatra Mrtvá", result.getStudentName());
//    }
//
//    @Test
//    void testFindById_existingName() {
//        when(studentRepository.findById(1)).thenReturn(Optional.of(student1));
//
//        Student result = studentService.findById(1);
//
//        assertNotEquals("Kleopatra Mrtvá", result.getStudentName());
//    }
//
//    @Test
//    void testFindById_nonExistingId() {
//        when(studentRepository.findById(3)).thenReturn(Optional.empty());
//
//        Student result = studentService.findById(3);
//
//        assertNull(result);
//    }
}
package org.example.examplefinalProject.service;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.entity.Teacher;
import org.example.examplefinalProject.repository.TeacherRepository;
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
public class TeacherServiceTest {
//
//    @Mock
//    private TeacherRepository teacherRepository;
//
//    @InjectMocks
//    private TeacherService teacherService;
//
//    private Teacher teacher1;
//    private Teacher teacher2;
//
//    @BeforeEach
//    void setUp() {
//        teacher1 = new Teacher();
//        teacher1.setTeacherId(1);
//        teacher1.setTeacherName("Gabriela Nápravníková");
//
//        teacher2 = new Teacher();
//        teacher2.setTeacherId(2);
//        teacher2.setTeacherName("Tomáš Bradavice");
//    }
//
//    @Test
//    void testFindAll() {
//        List<Teacher> teachers = Arrays.asList(teacher1, teacher2);
//        when(teacherRepository.findAll()).thenReturn(teachers);
//
//        List<Teacher> result = teacherService.findAll();
//
//        assertEquals(2, result.size());
//        assertEquals("Gabriela Nápravníková", result.get(0).getTeacherName());
//        assertEquals("Tomáš Bradavice", result.get(1).getTeacherName());
//    }
//
//    @Test
//    void testFindById_existingId() {
//        when(teacherRepository.findById(1)).thenReturn(Optional.of(teacher1));
//
//        Teacher result = teacherService.findById(1);
//
//        assertEquals("Gabriela Nápravníková", result.getTeacherName());
//    }
//
//    @Test
//    void testFindById_existingName() {
//        when(teacherRepository.findById(1)).thenReturn(Optional.of(teacher2));
//
//        Teacher result = teacherService.findById(1);
//
//        assertNotEquals("Alexandra Veliká", result.getTeacherName());
//    }
//
//    @Test
//    void testFindById_nonExistingId() {
//        when(teacherRepository.findById(3)).thenReturn(Optional.empty());
//
//        Teacher result = teacherService.findById(3);
//
//        assertNull(result);
//    }
}
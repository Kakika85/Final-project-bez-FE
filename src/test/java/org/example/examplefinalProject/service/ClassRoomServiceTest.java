package org.example.examplefinalProject.service;

import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.repository.ClassRoomRepository;
import org.example.examplefinalProject.repository.StudentRepository;
import org.example.examplefinalProject.service.ClassRoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClassRoomServiceTest {
//
//    @Mock
//    private ClassRoomRepository classRoomRepository;
//
//    @Mock
//    private StudentRepository studentRepository;
//
//    @InjectMocks
//    private ClassRoomService classRoomService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testFindAll() {
//        ClassRoom classRoom1 = new ClassRoom();
//        classRoom1.setClassRoomId(1);
//        ClassRoom classRoom2 = new ClassRoom();
//        classRoom2.setClassRoomId(2);
//
//        List<ClassRoom> classRooms = Arrays.asList(classRoom1, classRoom2);
//        when(classRoomRepository.findAll()).thenReturn(classRooms);
//
//        List<ClassRoom> result = classRoomService.findAll();
//
//        assertEquals(2, result.size());
//        assertEquals(1, result.get(0).getClassRoomId());
//        assertEquals(2, result.get(1).getClassRoomId());
//    }
//
//    @Test
//    public void testFindById() {
//        // Arrange
//        ClassRoom classRoom = new ClassRoom();
//        classRoom.setClassRoomId(1);
//        when(classRoomRepository.findById(1)).thenReturn(Optional.of(classRoom));
//
//        // Act
//        ClassRoom result = classRoomService.findById(1);
//
//        assertNotNull(result);
//        assertEquals(1, result.getClassRoomId());
//    }
//
//    @Test
//    public void testFindById_NotFound() {
//        when(classRoomRepository.findById(1)).thenReturn(Optional.empty());
//
//        ClassRoom result = classRoomService.findById(1);
//
//        assertNull(result);
//    }
//
//    @Test
//    public void testStudentCountById() {
//        when(studentRepository.countByClassRoomClassRoomId(1)).thenReturn(10);
//
//        int result = classRoomService.studentCountById(1);
//
//        assertEquals(10, result);
//    }
}

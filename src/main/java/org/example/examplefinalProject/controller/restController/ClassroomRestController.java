package org.example.examplefinalProject.controller.restController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.service.ClassRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/classroom")
public class ClassroomRestController {

    private final ClassRoomService classRoomService;

    @GetMapping("")
    public List<ClassRoom> getAllClassRooms() {
        return classRoomService.findAll();
    }

    @GetMapping("/{classRoomId}")
    public ResponseEntity<ClassRoom> getClassRoomById(@PathVariable int classRoomId) {
        ClassRoom classRoom = classRoomService.findById(classRoomId);
        if (classRoom != null) {
            return ResponseEntity.ok(classRoom);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{classRoomId}/studentCount")
    public ResponseEntity<Integer> getStudentCountByClassRoomId(@PathVariable int classRoomId) {
        int count = classRoomService.studentCountById(classRoomId);
        return ResponseEntity.ok(count);
    }

    @DeleteMapping("/deleteClassRoom/{classRoomId}")
    public ResponseEntity<String> deleteClassRoom(@PathVariable Integer classRoomId) {
        classRoomService.deleteClassRoom(classRoomId);
        return ResponseEntity.noContent().build();
    }
}
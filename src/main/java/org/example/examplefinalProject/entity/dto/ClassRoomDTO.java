package org.example.examplefinalProject.entity.dto;

import org.example.examplefinalProject.entity.Teacher;

public record ClassRoomDTO (
        Integer classRoomId,
        String classRoomName,
        Teacher classTeacher) {
}

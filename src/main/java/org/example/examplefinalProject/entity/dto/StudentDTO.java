package org.example.examplefinalProject.entity.dto;

import java.util.List;

public record StudentDTO(
        Integer studentId,
        String studentName,
        String studentSurname,
        String studentFullName,
        ClassRoomDTO classRoom,
        List<ParentDTO> parents
) {}

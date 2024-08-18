package org.example.examplefinalProject.entity.dto;


public record ParentDTO(
        Integer parentId,
        String parentName,
        String parentSurname,
        String parentEmail,
        String parentPhone,
        String parentFullName
) {}

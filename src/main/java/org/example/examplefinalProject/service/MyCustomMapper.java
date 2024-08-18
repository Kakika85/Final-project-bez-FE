package org.example.examplefinalProject.service;

import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Parent;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.entity.dto.ClassRoomDTO;
import org.example.examplefinalProject.entity.dto.ParentDTO;
import org.example.examplefinalProject.entity.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MyCustomMapper {
    public StudentDTO convertToDTO(Student student) {
        return new StudentDTO(
                student.getStudentId(),
                student.getStudentName(),
                student.getStudentSurname(),
                student.getFullName(),
                convertClassRoomToDTO(student.getClassRoom()),
                student.getParents().stream()
                        .map(this::convertParentToDTO)
                        .collect(Collectors.toList()));
    }

    private ParentDTO convertParentToDTO(Parent parent) {
        return new ParentDTO(
                parent.getParentId(),
                parent.getParentName(),
                parent.getParentSurname(),
                parent.getParentEmail(),
                parent.getParentPhone(),
                parent.getParentFullName()
        );
    }

    private ClassRoomDTO convertClassRoomToDTO(ClassRoom classRoom) {
        return new ClassRoomDTO(
                classRoom.getClassRoomId(),
                classRoom.getClassRoomName(),
                classRoom.getClassTeacher()
        );
    }

}

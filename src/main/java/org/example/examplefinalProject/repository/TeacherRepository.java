package org.example.examplefinalProject.repository;

import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Optional<Teacher> findByTeacherNameAndTeacherSurname (String teacherName, String teacherSurname);

}

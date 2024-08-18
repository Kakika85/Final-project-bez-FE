package org.example.examplefinalProject.repository;

import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {

}

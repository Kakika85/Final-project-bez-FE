package org.example.examplefinalProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "studentId")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String studentName;
    private String studentSurname;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "classRoomId")
    private ClassRoom classRoom;

    @ManyToMany
    @JoinTable(
            name = "student_parent",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id")
    )
    @OrderBy(value = "parentSurname, parentName")
    @JsonBackReference
    private List<Parent> parents;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer id) {
        this.studentId = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String name) {
        this.studentName = name;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String surname) {
        this.studentSurname = surname;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public String getFullName() {
        return studentName + " " + studentSurname;
    }

    @Override
    public String toString() {
        return String.format("%s %s [%d]", studentName, studentSurname, studentId);
    }
}

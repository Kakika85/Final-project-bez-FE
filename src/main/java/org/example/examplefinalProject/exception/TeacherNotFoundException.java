package org.example.examplefinalProject.exception;

public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException(String message) {
        super((message));
    }
}

package org.example.examplefinalProject.controller;


import lombok.Builder;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.exception.ClassRoomNotFoundException;
import org.example.examplefinalProject.exception.StudentNotFoundExeption;
import org.example.examplefinalProject.service.ClassRoomService;
import org.example.examplefinalProject.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Builder
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

   //využití loggeru pro zadávání postupného hledání
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);


    @GetMapping("/search")
    @ResponseBody
    public List<Student> searchStudent(@RequestParam String query){
        List<Student> students = studentService.searchByQuery(query);      // používá metodu searchByQuery v StudentService

    //Toto nám zaloguje JSON odpovědi
        logger.info("Students found: {}", students);
        return students;
    }


    private final ClassRoomService classRoomService;


    public StudentController(StudentService studentService, ClassRoomService classRoomService) {
        this.studentService = studentService;
        this.classRoomService = classRoomService;
    }

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("student/index");
        modelAndView.addObject("studentList", studentService.findAll());
        modelAndView.addObject("classRoomList", classRoomService.findAll());
        return modelAndView;
    }

    @GetMapping("/{studentId}")
    public ModelAndView detail(@PathVariable int studentId) {
        ModelAndView modelAndView = new ModelAndView("/student/detail");
        modelAndView.addObject("student", studentService.findById(studentId));
        return modelAndView;
    }

    @PostMapping("/createStudent")
    public String createStudent(@RequestParam String studentName,
                                @RequestParam String studentSurname,
                                @RequestParam Integer classRoomId,
                                RedirectAttributes redirectAttributes) {
        try {
            ClassRoom classRoom = classRoomService.findById(classRoomId);
            studentService.createStudent(studentName, studentSurname, classRoom.getClassRoomName());
            redirectAttributes.addFlashAttribute("message", "Student was created.");
        } catch (ClassRoomNotFoundException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/student";
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") Integer studentId, RedirectAttributes redirectAttributes){
        try {
            studentService.deleteStudent(studentId);
            redirectAttributes.addFlashAttribute("message", "Student was deleted.");
        } catch (StudentNotFoundExeption e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return"redirect:/student";
    }
}

package org.example.examplefinalProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.exception.TeacherNotFoundException;
import org.example.examplefinalProject.service.ClassRoomService;
import org.example.examplefinalProject.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final ClassRoomService classRoomService;

    public TeacherController(TeacherService teacherService, ClassRoomService classRoomService) {
        this.teacherService = teacherService;
        this.classRoomService = classRoomService;
    }

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/teacher/index");
        modelAndView.addObject("teacherList", teacherService.findAll());
        modelAndView.addObject("classRoomList", classRoomService.findAll());
        return modelAndView;
    }

    @GetMapping("/{teacherId}")
    public ModelAndView detail(@PathVariable int teacherId) {
        ModelAndView modelAndView = new ModelAndView("/teacher/detail");
        modelAndView.addObject("teacher", teacherService.findById(teacherId));
        return modelAndView;
    }
    @GetMapping("/teacher/createTeacher")
    public String showCreateTeacherForm(Model model) {
        List<ClassRoom> classRoomList = classRoomService.findAll();
        model.addAttribute("classRoomList", classRoomList);
        return "createTeacher";
    }
    @PostMapping("/createTeacher")
    public String createTeacher(@RequestParam String teacherName,
                                @RequestParam String teacherSurname,
                                @RequestParam Integer classRoomId,
                                RedirectAttributes redirectAttributes) {

        ClassRoom classRoom = classRoomService.findById(classRoomId);
        teacherService.createTeacher(teacherName, teacherSurname, classRoom.getClassRoomName());
        redirectAttributes.addFlashAttribute("message", "Student was created.");
        return "redirect:/teacher";
    }

    @PostMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam("teacherId") Integer teacherId, RedirectAttributes redirectAttributes) {
        try {
            teacherService.deleteTeacher(teacherId);
            redirectAttributes.addFlashAttribute("message", "Teacher was deleted.");
        } catch (TeacherNotFoundException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/teacher";
    }
}

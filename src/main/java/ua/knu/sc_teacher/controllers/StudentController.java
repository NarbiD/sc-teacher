package ua.knu.sc_teacher.controllers;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.knu.sc_teacher.dto.StudentShortDto;
import ua.knu.sc_teacher.services.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/api/courses/{id}/students")
    public List<StudentShortDto> findStudentsByCourse(@CookieValue("AuthToken") String token, @PathVariable Long id){
        return studentService.findAllByCourse(id).stream()
                .map(StudentShortDto::new)
                .collect(Collectors.toList());
    }
}

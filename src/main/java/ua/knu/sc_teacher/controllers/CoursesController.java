package ua.knu.sc_teacher.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.knu.sc_teacher.dto.CourseShortDto;
import ua.knu.sc_teacher.dto.ResponseWrapper;
import ua.knu.sc_teacher.model.Course;
import ua.knu.sc_teacher.model.Teacher;
import ua.knu.sc_teacher.services.CourseService;
import ua.knu.sc_teacher.services.TokensService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {
    public final CourseService courseService;
    public final TokensService tokenService;

    public CoursesController(CourseService courseService, TokensService tokenService) {
        this.courseService = courseService;
        this.tokenService = tokenService;
    }

    @GetMapping
    public List<CourseShortDto> getAllCourses (@CookieValue("AuthToken") String token) {
        Teacher teacher = tokenService.findOneByValue(token);
        List<Course> courses = courseService.findAllByTeacherId(teacher.getId());
        return courses.stream()
                .map(CourseShortDto::new)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editCourse(@CookieValue("AuthToken") String token, @PathVariable Long id, @RequestBody CourseShortDto editedCourse) {
        Teacher teacher = tokenService.findOneByValue(token);
        Optional<Course> oldCourse = courseService.findOneByIdAndTeacher(id, teacher);
        if (oldCourse.isPresent()) {
            Course course = oldCourse.get();
            course.editCourseInfo(editedCourse);
            courseService.save(course);
        }
        return ResponseEntity.ok((new ResponseWrapper("Course info was changed")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseWrapper> deleteCourse(@CookieValue("AuthToken") String token, @PathVariable Long id) {
        Teacher teacher = tokenService.findOneByValue(token);
        if (courseService.findOneByIdAndTeacher(id, teacher).isPresent()) {
            courseService.deleteById(id);
        }
        return ResponseEntity.ok(new ResponseWrapper("Course was deleted"));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> addCourse(@CookieValue("AuthToken") String token, @RequestBody CourseShortDto dto) {
        Teacher teacher = tokenService.findOneByValue(token);
        Course course = Course.builder()
                .title(dto.getTitle())
                .comment(dto.getComment())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .teacher(teacher)
                .build();
        course = courseService.save(course);
        return ResponseEntity.ok(new ResponseWrapper(course.getId()));
    }
}

package ua.knu.sc_teacher.services;

import ua.knu.sc_teacher.model.Course;
import ua.knu.sc_teacher.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAllByTeacherId(long id);
    Course save(Course course);
    void deleteById(Long id);
    Optional<Course> findOneByIdAndTeacher(Long id, Teacher teacher);
}

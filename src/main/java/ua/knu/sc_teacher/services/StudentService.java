package ua.knu.sc_teacher.services;

import ua.knu.sc_teacher.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllByCourse(Long id);
}

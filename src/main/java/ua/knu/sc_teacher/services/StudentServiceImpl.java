package ua.knu.sc_teacher.services;

import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.model.Student;
import ua.knu.sc_teacher.repository.CourseRepository;
import ua.knu.sc_teacher.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllByCourse(Long id) {
        return studentRepository.findAllByCourse(id);
    }
}

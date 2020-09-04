package ua.knu.sc_teacher.services;

import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.model.Course;
import ua.knu.sc_teacher.model.Teacher;
import ua.knu.sc_teacher.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAllByTeacherId(long id) {
        return courseRepository.findByTeacher_Id(id);
    }

    public Optional<Course> findOneByIdAndTeacher(Long id, Teacher teacher) {
        return courseRepository.findOneByIdAndTeacher(id, teacher);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }


}

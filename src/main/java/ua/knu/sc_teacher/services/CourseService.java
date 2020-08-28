package ua.knu.sc_teacher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.model.Course;
import ua.knu.sc_teacher.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAllByTeacherId(long id) {
        return courseRepository.findByTeacher_Id(id);
    }

}

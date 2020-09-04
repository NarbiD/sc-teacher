package ua.knu.sc_teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.knu.sc_teacher.model.Course;
import ua.knu.sc_teacher.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTeacher_Id(Long teacher_id);
    Optional<Course> findOneByIdAndTeacher(Long id, Teacher teacher);
}

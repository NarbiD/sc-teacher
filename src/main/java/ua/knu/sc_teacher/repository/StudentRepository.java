package ua.knu.sc_teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.knu.sc_teacher.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s join s.courses c where c.id = :id")
    List<Student> findAllByCourse(Long id);
}

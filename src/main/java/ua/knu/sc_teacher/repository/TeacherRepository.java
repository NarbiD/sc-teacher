package ua.knu.sc_teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.knu.sc_teacher.model.Teacher;
import ua.knu.sc_teacher.model.User;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findOneByLogin(String login);
}

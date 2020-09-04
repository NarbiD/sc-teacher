package ua.knu.sc_teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.knu.sc_teacher.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByCourse_Id(Long id);
}

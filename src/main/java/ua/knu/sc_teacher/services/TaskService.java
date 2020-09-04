package ua.knu.sc_teacher.services;

import ua.knu.sc_teacher.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllByCourse(Long id);
}

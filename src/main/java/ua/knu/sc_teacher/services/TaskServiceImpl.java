package ua.knu.sc_teacher.services;

import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.model.Task;
import ua.knu.sc_teacher.repository.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllByCourse(Long id) {
        return taskRepository.findAllByCourse_Id(id);
    }
}

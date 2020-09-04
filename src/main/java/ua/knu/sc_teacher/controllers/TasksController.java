package ua.knu.sc_teacher.controllers;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.knu.sc_teacher.dto.TaskShortDto;
import ua.knu.sc_teacher.services.TaskService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TasksController {

    final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/api/courses/{id}/tasks")
    public List<TaskShortDto> getTasks(@CookieValue("AuthToken") String token, @PathVariable Long id) {
        return taskService.findAllByCourse(id).stream()
                .map(TaskShortDto::new)
                .collect(Collectors.toList());
    }
}

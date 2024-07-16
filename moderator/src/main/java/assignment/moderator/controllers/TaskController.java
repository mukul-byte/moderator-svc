package assignment.moderator.controllers;

import assignment.moderator.dtos.CreateTaskDto;
import assignment.moderator.models.Task;
import assignment.moderator.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping()
    public Task createTask(@RequestBody CreateTaskDto createTaskDto) {
        try {
            Task task = this.taskService.createTask(createTaskDto);
            return task;
        } catch (RuntimeException e) {
            throw e;
        }
    }
}

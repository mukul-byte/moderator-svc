package assignment.moderator.controllers;

import assignment.moderator.dtos.CreateTaskDto;
import assignment.moderator.helpers.ErrorResponse;
import assignment.moderator.models.Task;
import assignment.moderator.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> createTask(@RequestBody CreateTaskDto createTaskDto) {
        try {
            Task task = this.taskService.createTask(createTaskDto);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(e.getMessage()));
        }
    }
}

package assignment.moderator.services;

import assignment.moderator.dtos.CreateTaskDto;
import assignment.moderator.models.Moderator;
import assignment.moderator.models.Task;
import assignment.moderator.repositories.TaskRepository;
import assignment.moderator.services.strategies.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModeratorService moderatorService;

    private AssignmentStrategy assignmentStrategy;

    private AssignmentFilters assignmentFilters;

    @PostConstruct
    public void init() {
        this.assignmentFilters = new AssignmentFilters(null, null, true);
        this.assignmentStrategy = new RoundRobinAssignment();
    }

    public Task createTask(CreateTaskDto createTaskDto) {
        return null;
    }

    public void allocateTasks() {
        //pull all moderators according to the filters
        List<Moderator> moderators = this.moderatorService.getModerators();

        //pull all tasks having moderator id null
        List<Task> unassignedTasks = this.taskRepository.findByModeratorIdIsNull();

        List<Task> assignedTask = assignmentStrategy.assignTasks(moderators, unassignedTasks, assignmentFilters);

        this.taskRepository.saveAll(assignedTask);
    }

    public void configureAssignmentStartegy(AssignmentStrategyEnum startegy) {
        this.assignmentStrategy = AssignmentStrategyFactory.getStartegy(startegy);
    }

    public void configureFilter(AssignmentFilters assignmentFilters) {
        this.assignmentFilters = assignmentFilters;
    }
}

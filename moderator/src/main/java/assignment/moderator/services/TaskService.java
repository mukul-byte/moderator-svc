package assignment.moderator.services;

import assignment.moderator.dtos.CreateTaskDto;
import assignment.moderator.exceptions.InvalidAssignmentStrategy;
import assignment.moderator.exceptions.JobNotExistException;
import assignment.moderator.exceptions.JobSeekerNotFoundException;
import assignment.moderator.models.*;
import assignment.moderator.repositories.TaskRepository;
import assignment.moderator.services.strategies.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static assignment.moderator.helpers.EnumValidator.getEnumValue;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModeratorService moderatorService;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobSeekerService jobSeeker;

    @Autowired
    private ReportReasonService reportReasonService;

    private AssignmentStrategy assignmentStrategy;

    private AssignmentFilters assignmentFilters;

    @PostConstruct
    public void init() {
        this.assignmentFilters = new AssignmentFilters(null, null, true);
        this.assignmentStrategy = new RoundRobinAssignment();
    }

    public Task createTask(CreateTaskDto createTaskDto) {

        Job job = this.jobService.getJobById(createTaskDto.getJobId());
        if(job==null){
            throw new JobNotExistException("Job not exist exception");
        }

        JobSeeker jobSeeker = this.jobSeeker.getJobSeekerById(createTaskDto.getReportedBy());
        if(jobSeeker==null){
            throw new JobSeekerNotFoundException("Job seeker not found");
        }

        ReportReason reason = this.reportReasonService.createOrGetByReportReason(createTaskDto.getReportReason());

        Task task = Task.builder()
                .job(job).reportedBy(jobSeeker).reportReason(reason).build();

        return this.taskRepository.save(task);
    }

    public void allocateTasks() {
        //pull all moderators according to the filters
        List<Moderator> moderators = this.moderatorService.getModerators();
        if(moderators.isEmpty()){
            return;
        }

        //pull all tasks having moderator id null
        List<Task> unassignedTasks = this.taskRepository.findByModeratorIdIsNull();
        if(unassignedTasks.isEmpty()){
            return;
        }

        List<Task> assignedTask = assignmentStrategy.assignTasks(moderators, unassignedTasks, assignmentFilters);

        this.taskRepository.saveAll(assignedTask);
    }

    public void configureAssignmentStrategy(String strategy) {
        AssignmentStrategyEnum assignmentStrategyEnum = getEnumValue(strategy, AssignmentStrategyEnum.class);
        if(assignmentStrategyEnum==null){
            throw new InvalidAssignmentStrategy("invalid assignment strategy");
        }
        this.assignmentStrategy = AssignmentStrategyFactory.getStartegy(assignmentStrategyEnum);
    }

    public void configureAssignmentFilter(AssignmentFilters assignmentFilters) {
        this.assignmentFilters = assignmentFilters;
    }
}

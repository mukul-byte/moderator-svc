package assignment.moderator.services;

import assignment.moderator.dtos.UpdateModeratorAbsentDto;
import assignment.moderator.dtos.UpdateModeratorDto;
import assignment.moderator.exceptions.ModeratorNotExistException;
import assignment.moderator.models.Moderator;
import assignment.moderator.models.Task;
import assignment.moderator.services.strategies.AssignmentFilters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminService {
    @Autowired
    private ModeratorService moderatorService;

    @Autowired
    private TaskService taskService;

    public Moderator updateModerator(UUID moderatorId, UpdateModeratorDto updateModeratorDto) {
        Moderator moderator = this.moderatorService.findById(moderatorId);
        if(moderator==null){
            throw new ModeratorNotExistException("moderator not exists exception");
        }

        if(updateModeratorDto.getPreferredLanguage()!=null){
            moderator.setPreferredLanguage(updateModeratorDto.getPreferredLanguage());
        }
        if(updateModeratorDto.getPreferredCity()!=null){
            moderator.setPreferredCity(updateModeratorDto.getPreferredCity());
        }
        if(updateModeratorDto.getShiftTime()!=null){
            moderator.setShiftTiming(updateModeratorDto.getShiftTime());
        }
        return this.moderatorService.save(moderator);
    }

    public Moderator updateModeratorAbsent(UUID moderatorId, UpdateModeratorAbsentDto updateModeratorAbsentDto) {
        Moderator moderator = this.moderatorService.findById(moderatorId);
        if(moderator==null){
            throw new ModeratorNotExistException("moderator not exists exception");
        }

        moderator.setAbsent(updateModeratorAbsentDto.isAbsent());
        return this.moderatorService.save(moderator);
    }

    public void configureAssignmentStrategy(String assignmentStrategy) {
        this.taskService.configureAssignmentStrategy(assignmentStrategy);
    }

    public void configureAssignmentFilter(AssignmentFilters assignmentFilters) {
        this.taskService.configureAssignmentFilter(assignmentFilters);
    }

    public Page<Task> monitorTasks(PageRequest pageRequest) {
        return taskService.findAll(pageRequest);
    }
}

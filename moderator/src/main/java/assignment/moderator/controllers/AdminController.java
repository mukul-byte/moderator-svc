package assignment.moderator.controllers;

import assignment.moderator.dtos.*;
import assignment.moderator.helpers.ErrorResponse;
import assignment.moderator.models.Moderator;
import assignment.moderator.models.Task;
import assignment.moderator.services.AdminService;
import assignment.moderator.services.strategies.AssignmentFilters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/moderator/{moderatorId}/update")
    public ResponseEntity<?> updateModerator(@PathVariable UUID moderatorId, @RequestBody UpdateModeratorDto updateModeratorDto) {
        try {
            Moderator response = this.adminService.updateModerator(moderatorId, updateModeratorDto);
            ModeratorResponseDto moderatorResponseDto = new ModeratorResponseDto(response);
            return new ResponseEntity<>(moderatorResponseDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping(value="/moderator/{moderatorId}/absent")
    public ResponseEntity<?> updateModeratorAbsent(@PathVariable UUID moderatorId, @RequestBody UpdateModeratorAbsentDto updateModeratorAbsentDto) {
        try {
            Moderator response = this.adminService.updateModeratorAbsent(moderatorId, updateModeratorAbsentDto);
            ModeratorResponseDto moderatorResponseDto = new ModeratorResponseDto(response);
            return new ResponseEntity<>(moderatorResponseDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping("/assignmentStrategy/{assignmentStrategy}")
    public ResponseEntity<?> configureAssignmentFilter(@PathVariable String assignmentStrategy){
        try{
            this.adminService.configureAssignmentStrategy(assignmentStrategy);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping("/assignmentFilter")
    public ResponseEntity<?> configureAssignmentFilter(@RequestBody AssignmentFilterDTO assignmentFilterDTO){
        try{
            AssignmentFilters assignmentFilter = new AssignmentFilters(assignmentFilterDTO);
            this.adminService.configureAssignmentFilter(assignmentFilter);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/monitor")
    @ResponseBody
    public ResponseEntity<List<TaskResponseDto>> getTasksByPage(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int count) {

        Page<Task> page = this.adminService.monitorTasks(PageRequest.of(pageNumber, count, Sort.by("createdAt").descending()));
        List<Task> tasks = page.getContent();

        List<TaskResponseDto> tasksResponses = new ArrayList<>();
        for(Task t: tasks){
            TaskResponseDto taskResponse = TaskResponseDto.builder()
                    .reportReason(t.getReportReason().getReason())
                    .jobCode(t.getJob().getJobCode())
                    .reportedByEmail(t.getReportedBy().getEmail())
                    .reportedByName(t.getReportedBy().getName())
                    .moderatorEmail(t.getModerator().getEmail())
                    .moderatorName(t.getModerator().getName())
                    .build();
            tasksResponses.add(taskResponse);
        }

        return ResponseEntity.ok(tasksResponses);
    }
}

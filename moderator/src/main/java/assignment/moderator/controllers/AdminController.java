package assignment.moderator.controllers;

import assignment.moderator.dtos.ModeratorResponseDto;
import assignment.moderator.dtos.UpdateModeratorAbsentDto;
import assignment.moderator.dtos.UpdateModeratorDto;
import assignment.moderator.models.Moderator;
import assignment.moderator.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/update/moderator/{moderatorId}")
    public ResponseEntity<ModeratorResponseDto> updateModerator(@PathVariable UUID moderatorId, @RequestBody UpdateModeratorDto updateModeratorDto) {
        try {
            Moderator response = this.adminService.updateModerator(moderatorId, updateModeratorDto);
            ModeratorResponseDto moderatorResponseDto = new ModeratorResponseDto(response);
            return new ResponseEntity<>(moderatorResponseDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/update/moderator/{moderatorId}/absent")
    public ResponseEntity<ModeratorResponseDto> updateModeratorAbsent(@PathVariable UUID moderatorId, @RequestBody UpdateModeratorAbsentDto updateModeratorAbsentDto) {
        try {
            Moderator response = this.adminService.updateModeratorAbsent(moderatorId, updateModeratorAbsentDto);
            ModeratorResponseDto moderatorResponseDto = new ModeratorResponseDto(response);
            return new ResponseEntity<>(moderatorResponseDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

//    @PostMapping("/assignmentStartegy"){}
}

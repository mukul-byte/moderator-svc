package assignment.moderator.dtos;

import assignment.moderator.models.Department;
import assignment.moderator.models.Moderator;
import assignment.moderator.models.helpers.ShiftTiming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class ModeratorResponseDto {
    private UUID id;
    private String name;
    private String email;
    private List<Department> departments;
    private String preferredLanguage;
    private ShiftTiming shiftTiming;
    private int performanceScore;
    private String preferredCity;
    private boolean absent;
    private boolean active;

    public ModeratorResponseDto(Moderator moderator){
        this.id = moderator.getId();
        this.name = moderator.getName();
        this.email = moderator.getEmail();;
        this.preferredCity = moderator.getPreferredCity();
        this.preferredLanguage = moderator.getPreferredLanguage();
        this.shiftTiming = moderator.getShiftTiming();
        this.absent = moderator.isAbsent();
        this.active = moderator.isActive();
        this.performanceScore = moderator.getPerformanceScore();
        this.departments = moderator.getDepartments();
    }
}

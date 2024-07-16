package assignment.moderator.services.strategies;

import assignment.moderator.dtos.AssignmentFilterDTO;
import assignment.moderator.models.helpers.ShiftTiming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentFilters {
    private String city;
    private ShiftTiming shiftTiming;
    private boolean excludeAbsent;

    public AssignmentFilters(AssignmentFilterDTO assignmentFilterDTO){
        this.city = assignmentFilterDTO.getCity();
        this.shiftTiming = assignmentFilterDTO.getShiftTiming();
        this.excludeAbsent = assignmentFilterDTO.isExcludeAbsent();
    }
}

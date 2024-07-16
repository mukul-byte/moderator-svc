package assignment.moderator.dtos;

import assignment.moderator.models.helpers.ShiftTiming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentFilterDTO {
    private String city;
    private ShiftTiming shiftTiming;
    private boolean excludeAbsent;
}

package assignment.moderator.services.strategies;

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
}

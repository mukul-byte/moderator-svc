package assignment.moderator.dtos;

import assignment.moderator.models.helpers.ShiftTiming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateModeratorDto {
    private String preferredLanguage;
    private String preferredCity;
    private ShiftTiming shiftTime;
}

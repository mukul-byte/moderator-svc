package assignment.moderator.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CreateTaskDto {
    private String reportReason;
    private UUID jobId;
    private UUID reportedBy;
}

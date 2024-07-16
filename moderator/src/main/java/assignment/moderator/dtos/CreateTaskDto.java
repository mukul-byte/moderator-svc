package assignment.moderator.dtos;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class CreateTaskDto {
    private String reportReason;
    private UUID jobId;
    private UUID reportedBy;
}

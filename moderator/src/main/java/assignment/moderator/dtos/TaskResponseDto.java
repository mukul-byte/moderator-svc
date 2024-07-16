package assignment.moderator.dtos;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaskResponseDto {
    private String reportReason;
    private String jobCode;
    private String reportedByName;
    private String reportedByEmail;
    private String moderatorName;
    private String moderatorEmail;
}

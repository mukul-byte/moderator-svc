package assignment.moderator.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task extends BaseClass{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_reason_id")
    private ReportReason reportReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="job_seeker_id")
    private JobSeeker reportedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="moderator_id")
    private Moderator moderator;
}

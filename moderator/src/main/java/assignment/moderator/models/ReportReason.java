package assignment.moderator.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor

@NoArgsConstructor
public class ReportReason extends BaseClass {
    private String reason;
}

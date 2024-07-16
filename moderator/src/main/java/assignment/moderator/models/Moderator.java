package assignment.moderator.models;

import assignment.moderator.models.helpers.ShiftTiming;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Moderator extends BaseClass{
    private String name;
    private String email;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private List<Department> departments;

    private String preferredLanguage;
    private ShiftTiming shiftTiming;
    private int performanceScore;
    private String preferredCity;
    private boolean absent;
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "moderator_id")
    private List<Task> assignedTasks;
}

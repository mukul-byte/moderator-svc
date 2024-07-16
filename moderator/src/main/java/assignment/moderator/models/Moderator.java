package assignment.moderator.models;

import assignment.moderator.models.helpers.ShiftTiming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
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
    @JoinColumn(name = "moderator_id")//, cascade = CascadeType.REMOVE)
    private List<Task> assignedTasks;
}

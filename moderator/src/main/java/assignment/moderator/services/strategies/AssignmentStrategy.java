package assignment.moderator.services.strategies;

import assignment.moderator.models.Moderator;
import assignment.moderator.models.Task;

import java.util.List;
import java.util.stream.Collectors;

public interface AssignmentStrategy {
    List<Task> assignTasks(List<Moderator> moderators, List<Task> task, AssignmentFilters filters);
    default List<Moderator> applyFilters(List<Moderator> moderators, AssignmentFilters filters) {
        return moderators.stream().filter(m->
                        (!(filters.isExcludeAbsent() && m.isAbsent())) ||
                        (!(filters.getCity() != null && !filters.getCity().equals(m.getPreferredCity()))) ||
                        (!(filters.getShiftTiming() != null && !filters.getShiftTiming().equals(m.getShiftTiming())))
                ).collect(Collectors.toList());
    }
}

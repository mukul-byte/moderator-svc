package assignment.moderator.services.strategies;

import assignment.moderator.models.Moderator;
import assignment.moderator.models.Task;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RoundRobinAssignment implements AssignmentStrategy {

    @Override
    public List<Task> assignTasks(List<Moderator> moderators, List<Task> task, AssignmentFilters filters) {
        int moderatorIndex = 0;
        int taskIdx = 0;
        moderators = applyFilters(moderators, filters);
        do {
            Moderator moderator = moderators.get(moderatorIndex);
                // Assign task to the moderator
                moderatorIndex = (moderatorIndex + 1) % moderators.size();
                task.get(taskIdx).setModerator(moderator);
                taskIdx++;

            moderatorIndex = (moderatorIndex + 1) % moderators.size();
        } while (taskIdx!= task.size());

        return task;
    }
}

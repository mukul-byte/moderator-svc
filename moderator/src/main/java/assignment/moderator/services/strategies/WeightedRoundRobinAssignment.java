package assignment.moderator.services.strategies;

import assignment.moderator.models.Moderator;
import assignment.moderator.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeightedRoundRobinAssignment implements AssignmentStrategy {

    @Override
    public List<Task> assignTasks(List<Moderator> moderators, List<Task> tasks, AssignmentFilters filters) {
        moderators = applyFilters(moderators, filters);
        ArrayList<Integer> weightArr = new ArrayList<>();
        int runSum = 0;
        for(Moderator m: moderators){
            runSum+= m.getPerformanceScore();
            weightArr.add(runSum);
        }

        for(Task task: tasks){
            int randomNumber = (int) (Math.random() * (runSum + 1));
            for(int idx=0;idx<weightArr.size();idx++) {
                if (randomNumber <= weightArr.get(idx)) {
                    task.setModerator(moderators.get(idx));
                    break;
                }
            }
        }

        return tasks;
    }
}

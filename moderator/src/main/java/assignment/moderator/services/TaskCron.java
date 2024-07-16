package assignment.moderator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskCron {

    @Autowired
    private TaskService taskService;

    @Scheduled(cron = "0 * * * * *") // Cron expression for running every minute
    public void execute() {
        try {
            System.out.println("Cron");
            taskService.allocateTasks();
        } catch (RuntimeException ex) {
            System.out.println("Error while running task cron: " + ex.getMessage());
        }
    }
}

package assignment.moderator;

import assignment.moderator.dtos.CreateTaskDto;
import assignment.moderator.models.*;
import assignment.moderator.repositories.JobRepository;
import assignment.moderator.repositories.JobSeekerRepository;
import assignment.moderator.services.ModeratorService;
import assignment.moderator.services.TaskService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModeratorTest {

    @Autowired
    ModeratorService moderatorService;

    @Autowired
    JobSeekerRepository jobSeekerRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    TaskService taskService;

    Random random = new Random();

    UUID jobId;
    UUID jobSeekerId;

    @Test
    @Order(1)
    public void createModerator() {
        List<Department> departments = Arrays.asList(new Department("CSE"), new Department("MCE"));
        Moderator moderator = Moderator.builder()
                .absent(false)
                .email("rohit@gmail.com")
                .active(true)
                .departments(departments)
                .preferredCity("New Delhi")
                .performanceScore(5)
                .build();

        moderatorService.save(moderator);
    }

    @Test
    @Order(2)
    public void createJobSeeker() {
        JobSeeker jobSeeker = new JobSeeker("Mukul", "Mkl167@gmail.com");
        JobSeeker savedJobSeeker = jobSeekerRepository.save(jobSeeker);
        jobSeekerId = savedJobSeeker.getId();
        System.out.println("JobSeeker created with id: " + savedJobSeeker.getId());
    }

    @Test
    @Order(3)
    public void createJob() {
        int randomNumber = random.nextInt(10000000);
        Job job = new Job("JD-" + randomNumber);
        Job savedJob = this.jobRepository.save(job);
        System.out.println("Job created with id: " + savedJob.getId());
        this.jobId = savedJob.getId();
    }

    @Test
    @Order(4)
    public void createTask() {
        try {
            List<String> reasons = Arrays.asList(
                    "Wrong Description",
                    "Fraud",
                    "Ask for Money",
                    "HR Misbehaved",
                    "Incorrect Job Information",
                    "No Response from HR");
            int randomNumber = this.random.nextInt(reasons.size());
            CreateTaskDto createTaskDto = CreateTaskDto.builder()
                    .jobId(this.jobRepository.findAll().get(0).getId())
                    .reportedBy(this.jobSeekerRepository.findAll().get(0).getId())
                    .reportReason(reasons.get(randomNumber))
                    .build();
            System.out.println(createTaskDto.toString());
            Task createdTask = taskService.createTask(createTaskDto);
            System.out.println("Task created with id: " + createdTask.getId());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}

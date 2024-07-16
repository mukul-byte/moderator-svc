package assignment.moderator;

import assignment.moderator.models.Department;
import assignment.moderator.models.Job;
import assignment.moderator.models.JobSeeker;
import assignment.moderator.models.Moderator;
import assignment.moderator.models.helpers.ShiftTiming;
import assignment.moderator.repositories.JobRepository;
import assignment.moderator.repositories.JobSeekerRepository;
import assignment.moderator.services.ModeratorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class ModeratorTest {

    @Autowired
    ModeratorService moderatorService;

    @Autowired
    JobSeekerRepository jobSeekerRepository;

    @Autowired
    JobRepository jobRepository;

    Random random = new Random();


    @Test
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
    public void createJobSeeker() {
        JobSeeker jobSeeker = new JobSeeker("Mukul", "Mkl167@gmail.com");
        JobSeeker savedJobSeeker = jobSeekerRepository.save(jobSeeker);
        System.out.println("JobSeeker created with id: "+ savedJobSeeker.getId());
    }

    @Test
    public void createJob() {
        int randomNumber = random.nextInt(10000000);
        Job job = new Job("JD-"+ randomNumber);
        Job savedJob  = this.jobRepository.save(job);
        System.out.println("Job created with id: "+ savedJob.getId());
    }
}

package assignment.moderator;

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
        Moderator moderator = new Moderator();
        moderator.setPreferredCity("Bengaluru");
        moderator.setShiftTiming(ShiftTiming.EVENING);
        moderator.setName("Rahul");

        moderatorService.save(moderator);
    }

    @Test
    public void createJobSeeker() {
        JobSeeker jobSeeker = new JobSeeker("Mukul", "Mkl167@gmail.com");
        jobSeekerRepository.save(jobSeeker);
    }

    @Test
    public void createJob() {
        int randomNumber = random.nextInt(10000000);
        Job job = new Job("JD-"+ randomNumber);
        Job savedJob  = this.jobRepository.save(job);
        System.out.println("Job created with id: "+ savedJob.getId());
    }
}

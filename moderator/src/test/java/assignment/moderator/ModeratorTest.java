package assignment.moderator;

import assignment.moderator.models.Job;
import assignment.moderator.models.JobSeeker;
import assignment.moderator.models.Moderator;
import assignment.moderator.repositories.JobRepository;
import assignment.moderator.repositories.JobSeekerRepository;
import assignment.moderator.services.ModeratorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ModeratorTest {

    @Autowired
    ModeratorService moderatorService;

    @Autowired
    JobSeekerRepository jobSeekerRepository;

    @Autowired
    JobRepository jobRepository;

    @Test
    public void createModerator() {
        Moderator moderator = new Moderator();
        moderator.setPreferredCity("Bengaluru");
        moderator.setShiftTiming("10:00");
        moderator.setEndTime("18:00");
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
        Job job = new Job("JD-654300");
        this.jobRepository.save(job);
    }
}

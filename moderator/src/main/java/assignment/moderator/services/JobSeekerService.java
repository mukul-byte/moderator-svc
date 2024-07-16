package assignment.moderator.services;

import assignment.moderator.models.JobSeeker;
import assignment.moderator.repositories.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class JobSeekerService {
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public JobSeeker getJobSeekerById(UUID jobSeekerId) {
        Optional<JobSeeker> jobSeekerOptional = this.jobSeekerRepository.findById(jobSeekerId);
        return jobSeekerOptional.orElse(null);
    }
}

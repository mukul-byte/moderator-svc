package assignment.moderator.services;

import assignment.moderator.models.Job;
import assignment.moderator.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public Job getJobById(UUID jobId) {
        Optional<Job> job = this.jobRepository.findById(jobId);
        return job.orElse(null);
    }
}

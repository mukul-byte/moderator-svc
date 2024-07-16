package assignment.moderator.repositories;

import assignment.moderator.models.JobSeeker;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, UUID> {

}

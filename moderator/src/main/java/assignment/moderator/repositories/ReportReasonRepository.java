package assignment.moderator.repositories;

import assignment.moderator.models.ReportReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReportReasonRepository extends JpaRepository<ReportReason, UUID> {
    Optional<ReportReason> findOneByReason(String reason);
}

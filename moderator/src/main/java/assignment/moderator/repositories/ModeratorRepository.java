package assignment.moderator.repositories;

import assignment.moderator.models.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ModeratorRepository extends JpaRepository<Moderator, UUID> {

    @Override
    List<Moderator> findAll();
}

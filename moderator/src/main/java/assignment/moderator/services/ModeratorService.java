package assignment.moderator.services;

import assignment.moderator.models.Moderator;
import assignment.moderator.repositories.ModeratorRepository;
import assignment.moderator.services.strategies.AssignmentFilters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModeratorService {
    @Autowired
    private ModeratorRepository moderatorRepository;

    public Moderator findById(UUID moderatorId) {
        Optional<Moderator> moderator = this.moderatorRepository.findById(moderatorId);
        return moderator.orElse(null);
    }

    public Moderator save(Moderator moderator) {
        return this.moderatorRepository.save(moderator);
    }

    public List<Moderator> getModerators() {
        return this.moderatorRepository.findAll();
    }
}

package de.examples.graal.consent.tracking.outbound;

import de.examples.graal.consent.tracking.domain.ConsentHistory;
import de.examples.graal.consent.tracking.domain.TrackingRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;

@Component
public class TrackingRepositoryImpl implements TrackingRepository {

    private final HashMap<UUID, ConsentHistory> repo;

    public TrackingRepositoryImpl() {
        repo = new HashMap<>();
    }

    @Override
    public void save(ConsentHistory history) {
        repo.put(history.getConsentId(), history);
    }

    @Override
    public ConsentHistory load(UUID uuid) {
        return repo.get(uuid);
    }
}

package de.examples.graal.consent.purpose.outbound;

import de.examples.graal.consent.consent.domain.purpose.PurposeVersion;
import de.examples.graal.consent.purpose.domain.PurposeAggregate;
import de.examples.graal.consent.purpose.domain.PurposeDomainEvent;
import de.examples.graal.consent.purpose.domain.PurposeFactory;
import de.examples.graal.consent.purpose.domain.PurposeRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PurposeRepositoryImpl implements PurposeRepository {

    private final HashMap<UUID, List<PurposeDomainEvent>> map;
    private final PurposeFactory factory;

    public PurposeRepositoryImpl(PurposeFactory factory) {
        this.factory = factory;
        this.map = new HashMap<>();
    }

    @Override
    public Mono<Void> save(PurposeDomainEvent event) {
        UUID key = event.getId();
        return Mono.justOrEmpty(map.put(key, addToList(event, key))).then();
    }

    private List<PurposeDomainEvent> addToList(PurposeDomainEvent event, UUID key) {
        ArrayList<PurposeDomainEvent> eventList = new ArrayList<>(map.getOrDefault(key, List.of()));
        eventList.add(event);
        return eventList;
    }

    @Override
    public Mono<PurposeAggregate> search(UUID uuid, PurposeVersion version) {
        return Mono.justOrEmpty(Optional.ofNullable(map.get(uuid)))
                .map(purposeDomainEvents -> purposeDomainEvents.stream()
                        //All events of same or smaller version
                        .filter(event -> event.getPurposeVersion().compareTo(version) != -1)
                        .collect(Collectors.toList()))
                .map(this.factory::replay);
    }

    // Strictly speaking this is impure, the domain logic of what latest means should be inside the domain?!
    @Override
    public Mono<PurposeAggregate> searchLatest(UUID id) {
        return Mono.justOrEmpty(Optional.ofNullable(map.get(id)))
                .map(this.factory::replay);
    }

    @Override
    public Flux<PurposeAggregate> all() {
        return Flux.fromIterable(map.values()).map(this.factory::replay);
    }
}

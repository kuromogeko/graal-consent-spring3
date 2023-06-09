package de.examples.graal.consent.purpose.domain;

import de.examples.graal.consent.consent.domain.purpose.PurposeVersion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PurposeRepository {
    Mono<Void> save(PurposeDomainEvent purposeAggregate);

    Mono<PurposeAggregate> search(UUID uuid, PurposeVersion version);

    Mono<PurposeAggregate> searchLatest(UUID id);

    Flux<PurposeAggregate> all();
}

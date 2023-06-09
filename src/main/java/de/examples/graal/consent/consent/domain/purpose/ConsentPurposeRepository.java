package de.examples.graal.consent.consent.domain.purpose;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ConsentPurposeRepository {

    Mono<Purpose> getPurpose(UUID purposeId);

    Mono<Void> save(Purpose purpose);

    Flux<Purpose> all();
}

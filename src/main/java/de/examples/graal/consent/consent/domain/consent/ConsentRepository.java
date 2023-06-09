package de.examples.graal.consent.consent.domain.consent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface ConsentRepository {
    Mono<ConsentAggregate> getById(UUID id);

    Mono<Void> save(ConsentAggregate consentAggregate);

    Mono<ConsentAggregate> getBySubjectAndPurposeRef(UUID subjectId, ReferencedPurpose referencedPurpose);

    Flux<ConsentAggregate> getByPurpose(UUID id);

    Flux<ConsentAggregate> getBySubjects(List<UUID> relevantSubjects);
}

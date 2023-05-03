package de.examples.graal.consent.consent.domain.consent;

import de.examples.graal.consent.consent.domain.DomainEventPublisher;
import de.examples.graal.consent.consent.domain.actors.Subject;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class ConsentFactory {

    private final DomainEventPublisher domainEventPublisher;

    public ConsentFactory(DomainEventPublisher domainEventPublisher) {
        this.domainEventPublisher = domainEventPublisher;
    }

    public Mono<ConsentAggregate> createConsent(GiveConsentCommand command, Subject subject) {
        return Mono.just(new ConsentAggregate(command.getReferencedPurpose(), Status.NONE, subject.getReference(), UUID.randomUUID(), domainEventPublisher));
    }


}

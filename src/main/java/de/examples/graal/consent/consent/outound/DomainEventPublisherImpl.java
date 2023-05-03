package de.examples.graal.consent.consent.outound;

import de.examples.graal.consent.consent.domain.DomainEvent;
import de.examples.graal.consent.consent.domain.DomainEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class DomainEventPublisherImpl implements DomainEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public DomainEventPublisherImpl(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publish(DomainEvent event) {
        this.applicationEventPublisher.publishEvent(event);
    }
}

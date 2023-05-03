package de.examples.graal.consent.consent.domain;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}

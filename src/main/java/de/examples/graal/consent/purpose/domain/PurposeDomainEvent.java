package de.examples.graal.consent.purpose.domain;

import de.examples.graal.consent.consent.domain.DomainEvent;
import de.examples.graal.consent.consent.domain.purpose.PurposeVersion;

import java.util.UUID;

public interface PurposeDomainEvent extends DomainEvent {
    UUID getId();

    PurposeVersion getPurposeVersion();
}

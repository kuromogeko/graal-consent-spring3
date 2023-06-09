package de.examples.graal.consent.purpose.domain;

import de.examples.graal.consent.consent.domain.purpose.PurposeVersion;
import de.examples.graal.consent.consent.domain.purpose.Viability;

import java.util.UUID;

public class PurposeCreatedEvent implements PurposeDomainEvent {
    private final UUID id;
    private final PurposeVersion version;
    private final String text;
    private final Viability viability;

    public UUID getId() {
        return id;
    }

    public PurposeVersion getPurposeVersion() {
        return version;
    }

    public PurposeCreatedEvent(UUID id, PurposeVersion version, String text, Viability viability) {
        this.id = id;
        this.version = version;
        this.text = text;
        this.viability = viability;
    }

    public String getText() {
        return text;
    }

    public Viability getViability() {
        return viability;
    }
}

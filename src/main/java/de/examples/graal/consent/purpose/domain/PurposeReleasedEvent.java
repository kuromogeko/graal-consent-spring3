package de.examples.graal.consent.purpose.domain;

import de.examples.graal.consent.consent.domain.purpose.PurposeVersion;
import de.examples.graal.consent.consent.domain.purpose.Viability;

import java.util.UUID;

public class PurposeReleasedEvent implements PurposeDomainEvent {
    private final UUID uuid;
    private final PurposeVersion purposeVersion;
    private final String text;
    private final Viability viability;

    public PurposeReleasedEvent(UUID uuid, PurposeVersion purposeVersion, String text, Viability viability) {
        this.uuid = uuid;
        this.purposeVersion = purposeVersion;
        this.text = text;
        this.viability = viability;
    }

    public UUID getId() {
        return uuid;
    }

    public PurposeVersion getPurposeVersion() {
        return purposeVersion;
    }

    public String getText() {
        return text;
    }

    public Viability getViability() {
        return viability;
    }
}

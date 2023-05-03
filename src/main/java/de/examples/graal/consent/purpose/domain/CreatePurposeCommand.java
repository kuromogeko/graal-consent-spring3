package de.examples.graal.consent.purpose.domain;

import de.examples.graal.consent.consent.domain.purpose.PurposeVersion;
import de.examples.graal.consent.consent.domain.purpose.Viability;

import java.util.UUID;

public class CreatePurposeCommand {
    private final String text;
    private final Viability viability;


    public CreatePurposeCommand(UUID id, String text, PurposeVersion purposeVersion, Viability viability, ReleaseStatus releaseStatus) {
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

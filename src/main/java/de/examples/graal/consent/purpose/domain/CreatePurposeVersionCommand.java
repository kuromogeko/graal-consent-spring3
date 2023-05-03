package de.examples.graal.consent.purpose.domain;

import java.util.UUID;

public class CreatePurposeVersionCommand {
    private final UUID id;
    private final String updatedText;

    public CreatePurposeVersionCommand(UUID id, String updatedText) {
        this.id = id;
        this.updatedText = updatedText;
    }

    public UUID getId() {
        return id;
    }

    public String getUpdatedText() {
        return updatedText;
    }
}

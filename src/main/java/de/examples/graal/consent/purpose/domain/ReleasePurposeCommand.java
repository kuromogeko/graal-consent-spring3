package de.examples.graal.consent.purpose.domain;

import de.examples.graal.consent.consent.domain.purpose.PurposeVersion;

import java.util.UUID;

public class ReleasePurposeCommand {
    private final UUID uuid;
    private final PurposeVersion version;

    public ReleasePurposeCommand(UUID uuid, PurposeVersion version) {
        this.uuid = uuid;
        this.version = version;
    }

    public UUID getUuid() {
        return uuid;
    }

    public PurposeVersion getVersion() {
        return version;
    }
}

package de.examples.graal.consent.purpose.outbound;

import de.examples.graal.consent.consent.domain.purpose.PurposeVersion;

import java.util.Objects;
import java.util.UUID;

public class PurposeKey {
    private final UUID uuid;
    private final PurposeVersion version;

    public PurposeKey(UUID uuid, PurposeVersion version) {
        this.uuid = uuid;
        this.version = version;
    }

    protected UUID getUuid() {
        return uuid;
    }

    protected PurposeVersion getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurposeKey that = (PurposeKey) o;
        return Objects.equals(getUuid(), that.getUuid()) && Objects.equals(getVersion(), that.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getVersion());
    }
}

package de.examples.graal.consent.consent.domain.actors;

import de.examples.graal.consent.consent.domain.consent.SubjectReference;
import de.examples.graal.consent.consent.domain.purpose.SubjectType;
import de.examples.graal.consent.consent.domain.purpose.TargetCharacteristic;

import java.util.UUID;

public interface Subject {
    boolean isOfType(SubjectType type);

    boolean hasCharacteristic(TargetCharacteristic characteristic);

    UUID getId();

    default SubjectReference getReference() {
        return new SubjectReference(this.getId());
    }
}

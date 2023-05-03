package de.examples.graal.consent.consent.domain.actors.user;

import de.examples.graal.consent.consent.domain.actors.Subject;
import de.examples.graal.consent.consent.domain.purpose.SubjectType;
import de.examples.graal.consent.consent.domain.purpose.TargetCharacteristic;

import java.util.Objects;
import java.util.UUID;

public class User implements Subject {
    private final UUID id;
    private final UserCharacteristic characteristic;

    public User(UUID id, UserCharacteristic characteristic) {
        this.id = id;
        this.characteristic = characteristic;
    }

    @Override
    public boolean isOfType(SubjectType type) {
        return SubjectType.USER.equals(type);
    }

    @Override
    public boolean hasCharacteristic(TargetCharacteristic characteristic) {
        return this.characteristic.isOfType(characteristic);
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(characteristic, user.characteristic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), characteristic);
    }
}

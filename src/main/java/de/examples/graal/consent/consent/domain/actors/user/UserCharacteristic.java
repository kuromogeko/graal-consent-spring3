package de.examples.graal.consent.consent.domain.actors.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import de.examples.graal.consent.consent.domain.purpose.TargetCharacteristic;

public class UserCharacteristic implements TargetCharacteristic {

    private final UserType characteristic;

    @JsonCreator
    public UserCharacteristic(UserType characteristic) {
        this.characteristic = characteristic;
    }

    @Override
    public UserType getCharacteristic() {
        return characteristic;
    }
}

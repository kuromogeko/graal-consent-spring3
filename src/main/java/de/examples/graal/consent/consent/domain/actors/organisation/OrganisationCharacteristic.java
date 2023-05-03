package de.examples.graal.consent.consent.domain.actors.organisation;

import de.examples.graal.consent.consent.domain.purpose.TargetCharacteristic;

public class OrganisationCharacteristic implements TargetCharacteristic {

    private final OrganisationType characteristic;

    public OrganisationCharacteristic(OrganisationType characteristic) {
        this.characteristic = characteristic;
    }

    @Override
    public OrganisationType getCharacteristic() {
        return characteristic;
    }
}

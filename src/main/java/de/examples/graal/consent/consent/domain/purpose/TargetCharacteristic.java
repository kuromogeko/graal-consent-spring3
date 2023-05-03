package de.examples.graal.consent.consent.domain.purpose;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.examples.graal.consent.consent.domain.actors.organisation.OrganisationCharacteristic;
import de.examples.graal.consent.consent.domain.actors.user.UserCharacteristic;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = UserCharacteristic.class, name = "USER"),
        @JsonSubTypes.Type(value = OrganisationCharacteristic.class, name = "ORGANIZATION")})
public interface TargetCharacteristic {
    default boolean isOfType(TargetCharacteristic targetCharacteristic) {
        return this.getCharacteristic().equals(targetCharacteristic.getCharacteristic());
    }

    Object getCharacteristic();
}

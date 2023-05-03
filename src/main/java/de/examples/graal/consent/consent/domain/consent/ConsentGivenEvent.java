package de.examples.graal.consent.consent.domain.consent;

import de.examples.graal.consent.consent.domain.DomainEvent;
import de.examples.graal.consent.consent.domain.actors.user.User;

import java.util.UUID;

public record ConsentGivenEvent(UUID consentId, ReferencedPurpose purpose, User user,
                                SubjectReference subjectReference) implements DomainEvent {
}

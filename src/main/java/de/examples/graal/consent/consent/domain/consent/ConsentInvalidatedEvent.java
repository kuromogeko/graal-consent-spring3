package de.examples.graal.consent.consent.domain.consent;

import de.examples.graal.consent.consent.domain.DomainEvent;

import java.util.UUID;

public record ConsentInvalidatedEvent(UUID consentId, ReferencedPurpose referencedPurpose,
                                      SubjectReference subjectReference) implements DomainEvent {

}


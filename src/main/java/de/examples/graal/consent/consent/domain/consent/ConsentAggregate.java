package de.examples.graal.consent.consent.domain.consent;

import de.examples.graal.consent.consent.domain.DomainEventPublisher;
import de.examples.graal.consent.consent.domain.DomainException;
import de.examples.graal.consent.consent.domain.ErrorType;
import de.examples.graal.consent.consent.domain.actors.user.User;
import de.examples.graal.consent.consent.domain.purpose.PurposeVersion;

import java.util.UUID;

//Aggregate
//Write Model
public class ConsentAggregate {
    private final ReferencedPurpose purpose;
    private Status status;
    private final SubjectReference subjectReference;
    private final UUID consentId;

    private transient final DomainEventPublisher domainEventPublisher;

    protected ConsentAggregate(ReferencedPurpose purpose, Status status, SubjectReference subjectReference, UUID consentId, DomainEventPublisher domainEventPublisher) {
        this.purpose = purpose;
        this.status = status;
        this.subjectReference = subjectReference;
        this.consentId = consentId;
        this.domainEventPublisher = domainEventPublisher;
    }

    public ConsentGivenEvent giveConsent(User user) {
        if (this.status == Status.GIVEN || this.status == Status.INVALID) {
            throw new DomainException("Consent is either already given or no longer valid", ErrorType.USER_ERROR);
        }
        this.status = Status.GIVEN;
        ConsentGivenEvent event = new ConsentGivenEvent(this.getConsentId(), this.getPurpose(), user, this.getSubjectReference());
        this.domainEventPublisher.publish(event);
        return event;
    }

    public UUID getConsentId() {
        return consentId;
    }

    public ReferencedPurpose getPurpose() {
        return purpose;
    }

    public SubjectReference getSubjectReference() {
        return subjectReference;
    }


    public Status getStatus() {
        return this.status;
    }

    public ConsentWithdrawnEvent withdrawConsent(User user) {
        if (this.status != Status.GIVEN) {
            throw new DomainException("Consent is not given, so cannot be withdrawn", ErrorType.USER_ERROR);
        }
        this.status = Status.WITHDRAWN;
        ConsentWithdrawnEvent event = new ConsentWithdrawnEvent(this.getConsentId(), this.getPurpose(), user, this.getSubjectReference());
        this.domainEventPublisher.publish(event);
        return event;
    }

    public void invalidateForSmallerVersions(PurposeVersion version) {
        if (this.purpose.getAgreedVersion().compareTo(version) >= 0) {
            return;
        }
        this.status = Status.INVALID;
        var event = new ConsentInvalidatedEvent(this.getConsentId(), this.getPurpose(), this.getSubjectReference());
        this.domainEventPublisher.publish(event);
    }
}

package de.examples.graal.consent.consent.domain.consent;

import java.util.UUID;

public class WithdrawConsentCommand {
    private final UUID consentId;


    public WithdrawConsentCommand(UUID consentId) {
        this.consentId = consentId;
    }

    public UUID getConsentId() {
        return consentId;
    }

}

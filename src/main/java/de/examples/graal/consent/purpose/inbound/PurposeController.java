package de.examples.graal.consent.purpose.inbound;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.examples.graal.consent.consent.domain.actors.Actor;
import de.examples.graal.consent.consent.domain.actors.Scope;
import de.examples.graal.consent.consent.domain.actors.user.User;
import de.examples.graal.consent.consent.domain.actors.user.UserCharacteristic;
import de.examples.graal.consent.consent.domain.actors.user.UserType;
import de.examples.graal.consent.consent.domain.purpose.PurposeVersion;
import de.examples.graal.consent.purpose.domain.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/admin/")
public class PurposeController {
    private final PurposeService purposeService;
    private Actor actor = new Actor(
            new User(UUID.randomUUID(), new UserCharacteristic(UserType.DEFAULT))
            , List.of(), List.of(Scope.ADMIN));

    public PurposeController(PurposeService purposeService) {
        this.purposeService = purposeService;
    }

    @GetMapping("/purposes")
    public Flux<PurposeAggregate> getPurposes(){
        return purposeService.getPurposes(actor);
    }

    @PostMapping(path = "purposes/")
    public Mono<PurposeCreatedEvent> createPurpose(@RequestBody CreatePurposeCommand command) {
        return purposeService.createPurpose(actor, command);
    }

    @PatchMapping("purposes/{id}")
    public Mono<PurposeVersionUpdatedEvent> updatePurpose(@RequestBody UpdateConsentCommandDto commandDto, @PathVariable UUID id) {
        var command = new CreatePurposeVersionCommand(id, commandDto.text());
        return purposeService.createPurposeVersion(actor, command);
    }

    @PostMapping("purposes/{id}/release")
    public Mono<PurposeReleasedEvent> releasePurpose(@RequestBody ReleasePurposeCommandDto commandDto, @PathVariable UUID id){
        var command = new ReleasePurposeCommand(id,commandDto.purposeVersion());
        return purposeService.releasePurpose(actor, command);
    }

    @JsonSerialize
    record ReleasePurposeCommandDto(PurposeVersion purposeVersion){

    }

    @JsonSerialize
    record UpdateConsentCommandDto(String text) {
    }
}

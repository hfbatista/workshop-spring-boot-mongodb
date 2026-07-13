package br.dev.hfbatista.workshopmongo.clients;

import br.dev.hfbatista.workshopmongo.dtos.BenefitActivationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CapitalizationClientMock {

    public PartnerClientResponse activate(
            BenefitActivationRequest.EligiblePartnerDTO partner,
            BenefitActivationRequest.UserActivationDTO user) {
        CapitalizationActivation activation = activateLuckyNumber(user);
        return new PartnerClientResponse("CAPITALIZACAO", activation.protocol());
    }

    private CapitalizationActivation activateLuckyNumber(
            BenefitActivationRequest.UserActivationDTO user) {
        String protocol = "LUCKY-NUMBER-" + UUID.randomUUID();
        return new CapitalizationActivation(protocol, user);
    }

    private record CapitalizationActivation(
            String protocol,
            BenefitActivationRequest.UserActivationDTO user) {
    }
}

package br.dev.hfbatista.workshopmongo.clients;

import br.dev.hfbatista.workshopmongo.dtos.BenefitActivationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BradescoInsuranceClientMock {

    public PartnerClientResponse activate(
            BenefitActivationRequest.EligiblePartnerDTO partner,
            BenefitActivationRequest.UserActivationDTO user) {
        return new PartnerClientResponse("BRADESCO_SEGURO", "SEG-" + UUID.randomUUID());
    }
}

package br.dev.hfbatista.workshopmongo.handlers;

import br.dev.hfbatista.workshopmongo.dtos.BenefitActivationRequest;

public record PartnerActivationContext(
        BenefitActivationRequest.ClubDTO club,
        BenefitActivationRequest.ClubComponentDTO component,
        BenefitActivationRequest.EligiblePartnerDTO partner,
        BenefitActivationRequest.UserActivationDTO user,
        String termId
) {
}

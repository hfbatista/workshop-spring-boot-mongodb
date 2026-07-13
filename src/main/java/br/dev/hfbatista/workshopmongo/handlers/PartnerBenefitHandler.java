package br.dev.hfbatista.workshopmongo.handlers;

import br.dev.hfbatista.workshopmongo.clients.PartnerClientResponse;

public interface PartnerBenefitHandler {

    String partnerCnpj();

    PartnerClientResponse activate(PartnerActivationContext context);
}

package br.dev.hfbatista.workshopmongo.handlers;

import br.dev.hfbatista.workshopmongo.clients.LoyalMeClientMock;
import br.dev.hfbatista.workshopmongo.clients.PartnerClientResponse;
import org.springframework.stereotype.Component;

@Component
public class LoyalMeBenefitHandler implements PartnerBenefitHandler {

    private static final String PARTNER_CNPJ = "12312312000101";

    private final LoyalMeClientMock client;

    public LoyalMeBenefitHandler(LoyalMeClientMock client) {
        this.client = client;
    }

    @Override
    public String partnerCnpj() {
        return PARTNER_CNPJ;
    }

    @Override
    public PartnerClientResponse activate(PartnerActivationContext context) {
        return client.activate(context.partner(), context.user());
    }
}

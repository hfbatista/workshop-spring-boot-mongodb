package br.dev.hfbatista.workshopmongo.handlers;

import br.dev.hfbatista.workshopmongo.clients.BradescoInsuranceClientMock;
import br.dev.hfbatista.workshopmongo.clients.PartnerClientResponse;
import org.springframework.stereotype.Component;

@Component
public class BradescoInsuranceBenefitHandler implements PartnerBenefitHandler {

    private static final String PARTNER_CNPJ = "12312312000103";

    private final BradescoInsuranceClientMock client;

    public BradescoInsuranceBenefitHandler(BradescoInsuranceClientMock client) {
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

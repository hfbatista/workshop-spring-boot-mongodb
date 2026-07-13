package br.dev.hfbatista.workshopmongo.clients;

import br.dev.hfbatista.workshopmongo.dtos.BenefitActivationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LoyalMeClientMock {

    private static final String CLUB_IDENTIFICATION_HEADER = "club-bradesco-beneficios";

    public PartnerClientResponse activate(
            BenefitActivationRequest.EligiblePartnerDTO partner,
            BenefitActivationRequest.UserActivationDTO user) {
        LoyalMeSession session = createSession(CLUB_IDENTIFICATION_HEADER);
        LoyalMeSubscription subscription = subscribe(
                session.token(),
                new LoyalMeSubscriber(user.nome(), user.clienteCpf()));

        return new PartnerClientResponse("LOYAL_ME", subscription.protocol());
    }

    private LoyalMeSession createSession(String clubIdentificationHeader) {
        String token = "LOYAL-TOKEN-" + UUID.randomUUID();
        return new LoyalMeSession(token, clubIdentificationHeader);
    }

    private LoyalMeSubscription subscribe(String sessionToken, LoyalMeSubscriber subscriber) {
        String protocol = "LOYAL-SUBSCRIPTION-" + UUID.randomUUID();
        return new LoyalMeSubscription(protocol, sessionToken, subscriber);
    }

    private record LoyalMeSession(String token, String clubIdentificationHeader) {
    }

    private record LoyalMeSubscriber(String name, String cpf) {
    }

    private record LoyalMeSubscription(
            String protocol,
            String sessionToken,
            LoyalMeSubscriber subscriber) {
    }
}

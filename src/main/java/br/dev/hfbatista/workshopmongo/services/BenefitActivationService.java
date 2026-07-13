package br.dev.hfbatista.workshopmongo.services;

import br.dev.hfbatista.workshopmongo.clients.PartnerClientResponse;
import br.dev.hfbatista.workshopmongo.dtos.BenefitActivationRequest;
import br.dev.hfbatista.workshopmongo.dtos.BenefitActivationResponse;
import br.dev.hfbatista.workshopmongo.models.BenefitActivationEntity;
import br.dev.hfbatista.workshopmongo.repositories.BenefitActivationRepository;
import br.dev.hfbatista.workshopmongo.handlers.PartnerActivationContext;
import br.dev.hfbatista.workshopmongo.handlers.PartnerBenefitHandlerRegistry;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class BenefitActivationService {

    private final BenefitActivationRepository repository;
    private final PartnerBenefitHandlerRegistry handlerRegistry;

    public BenefitActivationService(
            BenefitActivationRepository repository,
            PartnerBenefitHandlerRegistry handlerRegistry) {
        this.repository = repository;
        this.handlerRegistry = handlerRegistry;
    }

    public BenefitActivationResponse activate(BenefitActivationRequest request) {
        List<BenefitActivationEntity.PartnerActivation> activations = new ArrayList<>();

        if (request.clube().componentesClube() != null) {
            for (BenefitActivationRequest.ClubComponentDTO component
                    : request.clube().componentesClube()) {
                if (component.parceirosElegiveis() == null) {
                    continue;
                }

                for (BenefitActivationRequest.EligiblePartnerDTO partner
                        : component.parceirosElegiveis()) {
                    PartnerActivationContext context = new PartnerActivationContext(
                            request.clube(),
                            component,
                            partner,
                            request.usuario(),
                            request.idTermo());

                    activations.add(activatePartner(context));
                }
            }
        }

        String status = activations.stream().allMatch(item -> "ACTIVATED".equals(item.getStatus()))
                ? "COMPLETED"
                : "COMPLETED_WITH_UNSUPPORTED_PARTNERS";

        BenefitActivationEntity entity = new BenefitActivationEntity(
                null,
                request.clube().clubeId(),
                request.usuario().clienteId(),
                request.idTermo(),
                status,
                Instant.now(),
                activations);

        return BenefitActivationResponse.fromEntity(repository.save(entity));
    }

    private BenefitActivationEntity.PartnerActivation activatePartner(PartnerActivationContext context) {
        String normalizedCnpj = normalizeCnpj(context.partner().cnpjParceiro());
        PartnerClientResponse response = handlerRegistry.findByCnpj(normalizedCnpj)
                .map(handler -> handler.activate(context))
                .orElse(null);

        if (response == null) {
            return new BenefitActivationEntity.PartnerActivation(
                    normalizedCnpj, "UNKNOWN", context.partner().beneficioUuid(), "UNSUPPORTED", null);
        }

        return new BenefitActivationEntity.PartnerActivation(
                normalizedCnpj,
                response.partnerName(),
                context.partner().beneficioUuid(),
                "ACTIVATED",
                response.protocol());
    }

    private String normalizeCnpj(String cnpj) {
        return cnpj == null ? "" : cnpj.replaceAll("\\D", "");
    }
}

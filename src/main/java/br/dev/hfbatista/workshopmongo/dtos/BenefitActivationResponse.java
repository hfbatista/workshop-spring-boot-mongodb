package br.dev.hfbatista.workshopmongo.dtos;

import br.dev.hfbatista.workshopmongo.models.BenefitActivationEntity;

import java.time.Instant;
import java.util.List;

public record BenefitActivationResponse(
        String id,
        String clubId,
        String customerId,
        String termId,
        String status,
        Instant createdAt,
        List<PartnerActivationResult> partnerActivations
) {
    public static BenefitActivationResponse fromEntity(BenefitActivationEntity entity) {
        List<PartnerActivationResult> results = entity.getPartnerActivations().stream()
                .map(result -> new PartnerActivationResult(
                        result.getPartnerCnpj(),
                        result.getPartnerName(),
                        result.getBenefitId(),
                        result.getStatus(),
                        result.getProtocol()))
                .toList();

        return new BenefitActivationResponse(
                entity.getId(), entity.getClubId(), entity.getCustomerId(), entity.getTermId(),
                entity.getStatus(), entity.getCreatedAt(), results);
    }

    public record PartnerActivationResult(
            String partnerCnpj,
            String partnerName,
            String benefitId,
            String status,
            String protocol
    ) {
    }
}

package br.dev.hfbatista.workshopmongo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cBenefitActivations")
public class BenefitActivationEntity {

    @Id
    private String id;
    private String clubId;
    private String customerId;
    private String termId;
    private String status;
    private Instant createdAt;
    private List<PartnerActivation> partnerActivations = new ArrayList<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PartnerActivation {
        private String partnerCnpj;
        private String partnerName;
        private String benefitId;
        private String status;
        private String protocol;
    }
}

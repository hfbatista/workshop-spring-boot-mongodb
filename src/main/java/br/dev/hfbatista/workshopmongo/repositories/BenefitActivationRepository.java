package br.dev.hfbatista.workshopmongo.repositories;

import br.dev.hfbatista.workshopmongo.models.BenefitActivationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BenefitActivationRepository extends MongoRepository<BenefitActivationEntity, String> {
}

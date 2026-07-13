package br.dev.hfbatista.workshopmongo.handlers;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PartnerBenefitHandlerRegistry {

    private final Map<String, PartnerBenefitHandler> handlersByCnpj;

    public PartnerBenefitHandlerRegistry(List<PartnerBenefitHandler> handlers) {
        this.handlersByCnpj = handlers.stream()
                .collect(Collectors.toUnmodifiableMap(
                        PartnerBenefitHandler::partnerCnpj,
                        Function.identity()));
    }

    public Optional<PartnerBenefitHandler> findByCnpj(String normalizedCnpj) {
        return Optional.ofNullable(handlersByCnpj.get(normalizedCnpj));
    }
}

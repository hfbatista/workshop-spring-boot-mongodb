package br.dev.hfbatista.workshopmongo.controllers;

import br.dev.hfbatista.workshopmongo.dtos.BenefitActivationRequest;
import br.dev.hfbatista.workshopmongo.dtos.BenefitActivationResponse;
import br.dev.hfbatista.workshopmongo.services.BenefitActivationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/benefit-activations")
public class BenefitActivationController {

    private final BenefitActivationService service;

    public BenefitActivationController(BenefitActivationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BenefitActivationResponse> activate(@RequestBody BenefitActivationRequest request) {
        return ResponseEntity.ok(service.activate(request));
    }
}

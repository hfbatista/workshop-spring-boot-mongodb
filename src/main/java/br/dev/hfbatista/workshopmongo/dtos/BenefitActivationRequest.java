package br.dev.hfbatista.workshopmongo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public record BenefitActivationRequest(
        ClubDTO clube,
        UserActivationDTO usuario,
        @JsonProperty("id_termo") String idTermo
) {
    public record ClubDTO(
            @JsonProperty("clube_id") String clubeId,
            @JsonProperty("nome_clube") String nomeClube,
            @JsonProperty("descricao_clube") String descricaoClube,
            @JsonProperty("valor_mensal") BigDecimal valorMensal,
            boolean ativo,
            @JsonProperty("versao_clube") Integer versaoClube,
            @JsonProperty("codigo_segmento_cliente_clube") String codigoSegmentoClienteClube,
            @JsonProperty("componentes_clube") List<ClubComponentDTO> componentesClube
    ) {
    }

    public record ClubComponentDTO(
            String categoria,
            String tipo,
            @JsonProperty("descricao_vitrine") String descricaoVitrine,
            @JsonProperty("parceiros_elegiveis") List<EligiblePartnerDTO> parceirosElegiveis
    ) {
    }

    public record EligiblePartnerDTO(
            @JsonProperty("cnpj_parceiro") String cnpjParceiro,
            @JsonProperty("parceiro_uuid") String parceiroUuid,
            @JsonProperty("tipo_beneficio") String tipoBeneficio,
            @JsonProperty("beneficio_uuid") String beneficioUuid
    ) {
    }

    public record UserActivationDTO(
            @JsonProperty("cliente_id") String clienteId,
            @JsonProperty("cliente_cpf") String clienteCpf,
            String nome,
            String nomeSocial,
            String dataNascimento,
            String agencia,
            String contaCorrente,
            String email,
            String ddd,
            String telefone,
            AddressDTO endereco
    ) {
    }

    public record AddressDTO(
            String logradouro,
            String numero,
            String complemento,
            String bairro,
            String municipio,
            String uf,
            String cep
    ) {
    }
}

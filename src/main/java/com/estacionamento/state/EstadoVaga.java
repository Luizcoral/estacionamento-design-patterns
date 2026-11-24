package com.estacionamento.state;

import com.estacionamento.model.Veiculo;
import com.estacionamento.model.Vaga;

/**
 * Contrato do padrão State para uma vaga de estacionamento.
 * Cada estado concreto define como a vaga reage às operações de
 * ocupar e liberar, eliminando condicionais (if/else) na classe Vaga.
 */
public interface EstadoVaga {

    /**
     * Tenta ocupar a vaga com o veículo informado.
     *
     * @throws IllegalStateException se o estado atual não permitir ocupação
     */
    void ocupar(Vaga vaga, Veiculo veiculo);

    /**
     * Tenta liberar a vaga.
     *
     * @throws IllegalStateException se o estado atual não permitir liberação
     */
    void liberar(Vaga vaga);

    /**
     * Nome legível do estado (ex.: "Livre", "Ocupada").
     */
    String getNome();
}

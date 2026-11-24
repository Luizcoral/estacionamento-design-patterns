package com.estacionamento.state;

import com.estacionamento.model.Veiculo;
import com.estacionamento.model.Vaga;

/**
 * Estado "Ocupada": a vaga rejeita nova ocupação e aceita liberação.
 */
public class VagaOcupadaState implements EstadoVaga {

    @Override
    public void ocupar(Vaga vaga, Veiculo veiculo) {
        throw new IllegalStateException(
                "Vaga #" + vaga.getNumero() + " ja esta ocupada por " + vaga.getVeiculoAtual() + ".");
    }

    @Override
    public void liberar(Vaga vaga) {
        vaga.setVeiculoAtual(null);
        vaga.setEstado(new VagaLivreState());
    }

    @Override
    public String getNome() {
        return "Ocupada";
    }
}

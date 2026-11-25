package com.estacionamento.state;

import com.estacionamento.model.Veiculo;
import com.estacionamento.model.Vaga;

/**
 * Estado "Livre": a vaga aceita ocupação e rejeita liberação.
 */
public class VagaLivreState implements EstadoVaga {

    @Override
    public void ocupar(Vaga vaga, Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("O veiculo nao pode ser nulo.");
        }
        vaga.setVeiculoAtual(veiculo);
        vaga.setEstado(new VagaOcupadaState());
    }

    @Override
    public void liberar(Vaga vaga) {
        throw new IllegalStateException(
                "Vaga #" + vaga.getNumero() + " ja esta livre e nao pode ser liberada novamente.");
    }

    @Override
    public String getNome() {
        return "Livre";
    }
}

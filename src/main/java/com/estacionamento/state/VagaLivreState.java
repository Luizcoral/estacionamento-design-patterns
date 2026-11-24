package com.estacionamento.state;

import com.estacionamento.model.Vaga;
import com.estacionamento.model.Veiculo;

public class VagaLivreState implements EstadoVaga {

    @Override
    public void ocupar(Vaga vaga, Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("O veículo não pode ser nulo ao ocupar uma vaga.");
        }
        vaga.setVeiculoAtual(veiculo);
        vaga.setEstado(new VagaOcupadaState());
    }

    @Override
    public void liberar(Vaga vaga) {
        throw new IllegalStateException("A vaga #" + vaga.getNumero() + " já está livre.");
    }

    @Override
    public String getNome() {
        return "Livre";
    }
}
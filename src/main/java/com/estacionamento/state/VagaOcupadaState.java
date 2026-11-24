package com.estacionamento.state;

import com.estacionamento.model.Vaga;
import com.estacionamento.model.Veiculo;

public class VagaOcupadaState implements EstadoVaga {

    @Override
    public void ocupar(Vaga vaga, Veiculo veiculo) {
        throw new IllegalStateException("A vaga #" + vaga.getNumero() + " já está ocupada.");
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
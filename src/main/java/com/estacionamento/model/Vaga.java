package com.estacionamento.model;

import com.estacionamento.state.EstadoVaga;
import com.estacionamento.state.VagaLivreState;

public class Vaga {
    private int numero;
    private Veiculo veiculoAtual;
    private EstadoVaga estado;

    public Vaga(int numero) {
        this.numero = numero;
        this.estado = new VagaLivreState();
    }

    public void ocupar(Veiculo veiculo) {
        estado.ocupar(this, veiculo);
    }

    public void liberar() {
        estado.liberar(this);
    }

    public boolean estaOcupada() {
        return veiculoAtual != null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Veiculo getVeiculoAtual() {
        return veiculoAtual;
    }

    public void setVeiculoAtual(Veiculo veiculoAtual) {
        this.veiculoAtual = veiculoAtual;
    }

    public EstadoVaga getEstado() {
        return estado;
    }

    public void setEstado(EstadoVaga estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        if (estaOcupada()) {
            return "Vaga #" + numero + " [" + estado.getNome() + " por " + veiculoAtual + "]";
        }
        return "Vaga #" + numero + " [" + estado.getNome() + "]";
    }
}
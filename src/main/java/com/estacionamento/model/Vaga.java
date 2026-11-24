package com.estacionamento.model;

/**
 * Representa uma vaga do estacionamento.
 * Servirá como o contexto para o padrão State que será integrado na sequência.
 */
public class Vaga {
    private int numero;
    private Veiculo veiculoAtual;

    public Vaga(int numero) {
        this.numero = numero;
        this.veiculoAtual = null;
    }

    public int getNumero() {
        return numero;
    }

    public Veiculo getVeiculoAtual() {
        return veiculoAtual;
    }

    public void setVeiculoAtual(Veiculo veiculoAtual) {
        this.veiculoAtual = veiculoAtual;
    }

    public boolean estaOcupada() {
        return this.veiculoAtual != null;
    }

    @Override
    public String toString() {
        return "Vaga #" + numero + " [" + (estaOcupada() ? "Ocupada por " + veiculoAtual : "Livre") + "]";
    }
}

package com.estacionamento.model;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Representa o registro de permanência de um veículo em uma vaga,
 * armazenando horário de entrada e saída para cálculo posterior de tarifa.
 */
public class Permanencia {
    private Veiculo veiculo;
    private Vaga vaga;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public Permanencia(Veiculo veiculo, Vaga vaga) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.horaEntrada = LocalDateTime.now();
    }

    public Permanencia(Veiculo veiculo, Vaga vaga, LocalDateTime horaEntrada) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.horaEntrada = horaEntrada;
    }

    public void finalizarPermanencia() {
        this.horaSaida = LocalDateTime.now();
    }

    public void finalizarPermanencia(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    /**
     * Retorna a quantidade de horas de permanência (mínimo de 1 hora cobrada).
     */
    public long calcularHoras() {
        LocalDateTime fim = (this.horaSaida != null) ? this.horaSaida : LocalDateTime.now();
        Duration duracao = Duration.between(this.horaEntrada, fim);
        long minutos = duracao.toMinutes();
        
        if (minutos <= 0) {
            return 1;
        }
        // Arredonda para cima se passar de Frações de hora
        return (long) Math.ceil(minutos / 60.0);
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    @Override
    public String toString() {
        return "Permanencia [Veiculo: " + veiculo.getPlaca() + 
               ", Vaga: " + vaga.getNumero() + 
               ", Entrada: " + horaEntrada + 
               ", Saida: " + (horaSaida != null ? horaSaida : "Em andamento") + "]";
    }
}

package model;

import java.time.LocalDateTime;

public class Horario {

    private LocalDateTime dataHora;

    private Sala sala;

    private Filme filme;

    public Horario() {
    }

    public Horario(LocalDateTime dataHora, Sala sala, Filme filme) {
        this.dataHora = dataHora;
        this.sala = sala;
        this.filme = filme;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

}

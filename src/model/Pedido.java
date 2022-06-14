package model;

public class Pedido {

    private Long id;

    private HorarioSessao horarioSessao;

    private StatusPedido status;

    private Pessoa pessoa;

    public Pedido(Long id, HorarioSessao horarioSessao, StatusPedido status, Pessoa pessoa) {
        this.id = id;
        this.horarioSessao = horarioSessao;
        this.status = status;
        this.pessoa = pessoa;
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HorarioSessao getHorarioSessao() {
        return horarioSessao;
    }

    public void setHorarioSessao(HorarioSessao horarioSessao) {
        this.horarioSessao = horarioSessao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}

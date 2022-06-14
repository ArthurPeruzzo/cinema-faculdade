package model;

public enum StatusPedido {

    PAGO("Pago"),
    PEMDENTE("Pendente"),
    CANCELADO("Cancelado");

    private String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}

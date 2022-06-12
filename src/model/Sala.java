package model;

public class Sala {

    private Long id;

    private String codigo;

    private Cidade cidade;

    public Sala() {
    }

    public Sala(String codigo, Cidade cidade) {
        this.codigo = codigo;
        this.cidade = cidade;
    }

    public Sala(Long id, String codigo, Cidade cidade) {
        this.id = id;
        this.codigo = codigo;
        this.cidade = cidade;
    }

    public Sala(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}

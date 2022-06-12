package model;

public class Estado {

    private Long id;

    private String uf;

    public Estado() {
    }

    public Estado(String uf) {
        this.uf = uf;
    }

    public Estado(Long id) {
        this.id = id;
    }

    public Estado(Long id, String uf) {
        this.id = id;
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}

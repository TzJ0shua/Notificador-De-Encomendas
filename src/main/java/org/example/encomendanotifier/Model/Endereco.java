package org.example.encomendanotifier.Model;

public class Endereco {
    private String lote;
    private String quadra;
    private String vale;

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getQuadra() {
        return quadra;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public String getVale() {
        return vale;
    }

    public void setVale(String vale) {
        this.vale = vale;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "quadra='" + quadra + '\'' +
                ", lote='" + lote + '\'' +
                '}';
    }
}

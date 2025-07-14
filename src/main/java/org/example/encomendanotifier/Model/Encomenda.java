package org.example.encomendanotifier.Model;

public class Encomenda {
    private Condomino destinatario;
    private String codigoRastreio;
    private String descricao;
    private String imagem;

    public Condomino getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Condomino destinatario) {
        this.destinatario = destinatario;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}

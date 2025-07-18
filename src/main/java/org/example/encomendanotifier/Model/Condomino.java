package org.example.encomendanotifier.Model;

import java.util.UUID;

public class Condomino {
    private String nome;
    private Endereco endereco;
    private String celular;
    private UUID id;

    public Condomino(){
        UUID uuid = UUID.randomUUID();
        this.id = uuid;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getQuadra() {
        return endereco != null ? endereco.getQuadra() : "";
    }

    public String getLote() {
        return endereco != null ? endereco.getLote() : "";
    }

    public String getVale() {
        return endereco != null ? endereco.getVale() : "";
    }

    @Override
    public String toString() {
        return  nome + " - " + (endereco != null ? endereco.toString() : "null");
    }
}
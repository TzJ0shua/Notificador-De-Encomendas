package org.example.encomendanotifier.Repository;

import org.example.encomendanotifier.Model.Encomenda;

import java.util.ArrayList;
import java.util.UUID;

public class EncomendaRepository {
    public static ArrayList<Encomenda> encomendas = new ArrayList<>();

    public static ArrayList<Encomenda> getEncomendas(){ return encomendas; }

    public static void setEncomendas(ArrayList<Encomenda> encomendas) {EncomendaRepository.encomendas = encomendas;}

    public static void addEncomenda(Encomenda novaEncomenda){
        EncomendaRepository.encomendas.add(novaEncomenda);
        System.out.println("Nova encomenda adicionada: " + novaEncomenda);
    }

    public String toString(){
        return null;
    }

    public static boolean removerEncomendaPorId(UUID id){
        return encomendas.removeIf(encomenda -> encomenda.getId().equals(id));
    }
}

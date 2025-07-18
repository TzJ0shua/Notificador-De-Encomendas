package org.example.encomendanotifier.Repository;

import org.example.encomendanotifier.Model.Condomino;

import java.util.ArrayList;
import java.util.UUID;

public class CondominoRepository {
    public static ArrayList<Condomino> condominos = new ArrayList<>();

    public static ArrayList<Condomino> getCondominos() {
        return condominos;
    }

    public static void setCondominos(ArrayList<Condomino> condominos) {
        CondominoRepository.condominos = condominos;
    }

    public static void addCondominos(Condomino novoCondomino){
        CondominoRepository.condominos.add(novoCondomino);
        System.out.println("Condomino adicionado: " + novoCondomino);
    }

    public String toString(){
        return null;
    }

    public static boolean removerCondominoPorId(UUID id){
        return condominos.removeIf(condomino -> condomino.getId().equals(id));
    }
}

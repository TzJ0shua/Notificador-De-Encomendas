package org.example.encomendanotifier;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.encomendanotifier.Model.Condomino;
import org.example.encomendanotifier.Model.Endereco;
import org.example.encomendanotifier.Repository.CondominoRepository;

import java.io.IOException;

public class HomeApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApp.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 620);

        scene.getStylesheets().add(getClass().getResource("/org/example/encomendanotifier/styles/home-style.css").toExternalForm());

        stage.setTitle("Controle de Encomendas VDC");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Condomino novoCondomino = new Condomino();
        novoCondomino.setNome("Joshua Teles de Souza");
        novoCondomino.setCelular("22997047165");
        Endereco novoEndereco = new Endereco();
        novoEndereco.setVale("4");
        novoEndereco.setLote("190T");
        novoCondomino.setEndereco(novoEndereco);
        CondominoRepository.addCondominos(novoCondomino);
        launch();
    }
}
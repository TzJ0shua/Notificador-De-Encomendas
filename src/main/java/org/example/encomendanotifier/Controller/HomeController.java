package org.example.encomendanotifier.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    public void abrirTelaTabelaCondominos() throws IOException {
        abrirTelas("/org/example/encomendanotifier/lista-condominos.fxml",
                "/org/example/encomendanotifier/styles/lista-condominos.css",
                "Tabela de Condôminos Cadastrados");
    }

    @FXML
    public void abrirTelaEncomendas() throws IOException {
        abrirTelas("/org/example/encomendanotifier/cadastro-encomenda.fxml",
                "/org/example/encomendanotifier/styles/cadastro-encomenda.css",
                "Cadastro de Encomenda");
    }
    
    @FXML
    public void abrirTelaCondomino() throws IOException {
        abrirTelas("/org/example/encomendanotifier/cadastro-condomino.fxml",
                "/org/example/encomendanotifier/styles/cadastro-condomino.css",
                "Cadastro de Condômino");
    }

    @FXML
    public void abrirTelaWhatsapp() throws IOException {
        abrirTelas("/org/example/encomendanotifier/whatsapp-notification.fxml",
                "/org/example/encomendanotifier/styles/cadastro-condomino.css",
                "Cadastro de Condômino");
    }

    protected void abrirTelas(String tela, String style, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(tela));
        Scene scene = new Scene(fxmlLoader.load());

        scene.getStylesheets().add(getClass().getResource(style).toExternalForm());

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.showAndWait();
    }
}

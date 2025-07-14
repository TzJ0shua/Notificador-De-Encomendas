package org.example.encomendanotifier.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;

public class CadastroEncomendaController {

    @FXML private ComboBox<String> condominoComboBox;
    @FXML private TextField campoCodigoRastreio;
    @FXML private TextArea campoDescricao;
    @FXML private TextField campoCaminhoImagem;

    @FXML
    private void selecionarImagem() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar Imagem da Encomenda");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg")
        );
        File arquivo = fileChooser.showOpenDialog(null);
        if (arquivo != null) {
            campoCaminhoImagem.setText(arquivo.getAbsolutePath());
        }
    }

    @FXML
    private void salvarEncomenda() {
        String nomeCondomino = condominoComboBox.getValue();
        String codigo = campoCodigoRastreio.getText();
        String descricao = campoDescricao.getText();
        String imagem = campoCaminhoImagem.getText();

        // Salvar no banco ou lista
        System.out.println("Nova encomenda para " + nomeCondomino + " com código " + codigo);
    }
}

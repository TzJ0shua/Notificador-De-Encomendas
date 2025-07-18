package org.example.encomendanotifier.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.example.encomendanotifier.Model.Condomino;
import org.example.encomendanotifier.Model.Encomenda;
import org.example.encomendanotifier.Repository.CondominoRepository;
import org.example.encomendanotifier.Repository.EncomendaRepository;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroEncomendaController implements Initializable {

    @FXML private ComboBox<Condomino> condominoComboBox;
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
        Condomino condomino = condominoComboBox.getValue();
        String codigo = campoCodigoRastreio.getText();
        String descricao = campoDescricao.getText();
        String imagem = campoCaminhoImagem.getText();

        // Salvar no banco ou lista
        Encomenda novaEncomenda = new Encomenda();
        novaEncomenda.setDestinatario(condomino);
        novaEncomenda.setCodigoRastreio(codigo);
        novaEncomenda.setDescricao(descricao);
        novaEncomenda.setImagem(imagem);

        System.out.println("Nova encomenda para " + condomino + " com código " + codigo);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        for (Condomino c : CondominoRepository.getCondominos()){
            condominoComboBox.getItems().add(c);
        }
    }
}

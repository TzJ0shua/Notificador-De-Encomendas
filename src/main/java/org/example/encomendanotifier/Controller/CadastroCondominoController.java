package org.example.encomendanotifier.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.encomendanotifier.Model.Condomino;
import org.example.encomendanotifier.Model.Endereco;
import org.example.encomendanotifier.Repository.CondominoRepository;

public class CadastroCondominoController {

    @FXML private TextField nomeField;
    @FXML private TextField celularField;
    @FXML private TextField quadraField;
    @FXML private TextField loteField;
    @FXML private TextField valeField;

    @FXML
    private void salvarCondomino() {
        if (camposInvalidos()) return;

        Condomino novoCondomino = criarCondomino();

        CondominoRepository.addCondominos(novoCondomino);

        // Aqui você pode salvar no banco, lista ou serviço
        System.out.println("Condomino salvo: "
                + novoCondomino.getNome() + ", "
                + novoCondomino.getCelular() + ", "
                + novoCondomino.getEndereco().getQuadra() + ", "
                + novoCondomino.getEndereco().getLote() + ", "
                + novoCondomino.getEndereco().getVale());

        mostrarAlerta("Cadastro de Condômino", "Condômino cadastrado com sucesso.", Alert.AlertType.INFORMATION);

        Stage stage = (Stage) nomeField.getScene().getWindow();
        stage.close();
    }

    private Condomino criarCondomino() {
        Condomino novoCondomino = new Condomino();
        Endereco endereco = new Endereco();

        endereco.setQuadra(quadraField.getText().trim());
        endereco.setLote(loteField.getText().trim());
        endereco.setVale(valeField.getText().trim());

        novoCondomino.setNome(nomeField.getText().trim());
        novoCondomino.setCelular(celularField.getText().trim());
        novoCondomino.setEndereco(endereco);

        return novoCondomino;
    }

    private boolean camposInvalidos() {
        if (nomeField.getText().trim().isEmpty()) {
            mostrarAlerta("Campo obrigatório", "Por favor, preencha o nome completo.", Alert.AlertType.WARNING);
            return true;
        }
        if (celularField.getText().trim().isEmpty()) {
            mostrarAlerta("Campo obrigatório", "Por favor, preencha o celular.", Alert.AlertType.WARNING);
            return true;
        }
        if (valeField.getText().trim().isEmpty()) {
            mostrarAlerta("Campo obrigatório", "Por favor, preencha o vale.", Alert.AlertType.WARNING);
            return true;
        }
        if (loteField.getText().trim().isEmpty()) {
            mostrarAlerta("Campo obrigatório", "Por favor, preencha o lote.", Alert.AlertType.WARNING);
            return true;
        }
        return false;
    }

    private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipoAlerta) {
        Alert alert = new Alert(tipoAlerta);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}

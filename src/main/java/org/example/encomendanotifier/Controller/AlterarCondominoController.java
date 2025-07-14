package org.example.encomendanotifier.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.encomendanotifier.Model.Condomino;
import org.example.encomendanotifier.Model.Endereco;

public class AlterarCondominoController {
    @FXML private TextField nomeField;
    @FXML private TextField celularField;
    @FXML private TextField quadraField;
    @FXML private TextField loteField;
    @FXML private TextField valeField;

    private Condomino condomino;

    public void setCondomino(Condomino condomino){
        this.condomino = condomino;

        // Preenche os campos com os dados existentes
        nomeField.setText(condomino.getNome());
        celularField.setText(condomino.getCelular());
        Endereco e = condomino.getEndereco();
        if (e != null) {
            quadraField.setText(e.getQuadra());
            loteField.setText(e.getLote());
            valeField.setText(e.getVale());
        }
    }

    @FXML
    private void salvarAlteracoes() {
        if (condomino != null) {
            condomino.setNome(nomeField.getText().trim());
            condomino.setCelular(celularField.getText().trim());

            Endereco e = new Endereco();
            e.setQuadra(quadraField.getText().trim());
            e.setLote(loteField.getText().trim());
            e.setVale(valeField.getText().trim());

            condomino.setEndereco(e);

            // Aqui você pode atualizar no repositório
            // CondominoRepository.update(condomino);
        }

        // Fecha a janela
        nomeField.getScene().getWindow().hide();
    }
}

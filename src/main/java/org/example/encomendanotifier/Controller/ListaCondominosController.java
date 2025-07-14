package org.example.encomendanotifier.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.encomendanotifier.Model.Condomino;
import org.example.encomendanotifier.Repository.CondominoRepository;

import java.io.IOException;

public class ListaCondominosController {

    @FXML private TableView<Condomino> tabelaCondominos;
    @FXML private TableColumn<Condomino, String> colNome;
    @FXML private TableColumn<Condomino, String> colCelular;
    @FXML private TableColumn<Condomino, String> colQuadra;
    @FXML private TableColumn<Condomino, String> colLote;
    @FXML private TableColumn<Condomino, String> colVale;
    @FXML private Button btnAlterar;
    @FXML private Button btnVoltar;
    @FXML private Button btnDeletar;

    private final ObservableList<Condomino> listaCondominos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCelular.setCellValueFactory(new PropertyValueFactory<>("celular"));
        colQuadra.setCellValueFactory(new PropertyValueFactory<>("quadra"));
        colLote.setCellValueFactory(new PropertyValueFactory<>("lote"));
        colVale.setCellValueFactory(new PropertyValueFactory<>("vale"));


        // Carrega dados do repositório
        listaCondominos.setAll(CondominoRepository.getCondominos());
        tabelaCondominos.setItems(listaCondominos);

        btnAlterar.setDisable(true);
        tabelaCondominos.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            btnAlterar.setDisable(newSel == null);
        });
    }

    @FXML
    public void onAlterarClick() throws IOException {
        Condomino selecionado = tabelaCondominos.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/encomendanotifier/alterar-condomino.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            scene.getStylesheets().add(getClass().getResource("/org/example/encomendanotifier/styles/cadastro-condomino.css").toExternalForm());
            // TODO: passar o objeto para o controller se for editar

            Stage stage = new Stage();
            stage.setTitle("Alterar Dados do Condômino");
            stage.setScene(scene);
            stage.sizeToScene();
            stage.showAndWait();

            // Atualiza a lista após a edição
            listaCondominos.setAll(CondominoRepository.getCondominos());
        }
    }

    @FXML
    public void onVoltarClick() {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onDeletarClick(){
        Stage stage = (Stage) btnDeletar.getScene().getWindow();
        stage.close();
    }
}

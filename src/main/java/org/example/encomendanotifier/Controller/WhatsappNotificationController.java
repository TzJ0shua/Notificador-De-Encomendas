package org.example.encomendanotifier.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.example.encomendanotifier.Model.Encomenda;

import java.io.ByteArrayInputStream;

public class WhatsappNotificationController {

    @FXML private Label mensagemVazia;
    @FXML private VBox encomendaBox;
    @FXML private Label labelDestinatario;
    @FXML private Label labelEndereco;
    @FXML private Label labelCodigo;
    @FXML private ImageView imagemEncomenda;
    @FXML private ImageView qrCodeImagem;

    private Encomenda encomendaAtual;

    public void carregarEncomenda(Encomenda encomenda, byte[] qrCodeBytes) {
        if (encomenda == null) {
            encomendaBox.setVisible(false);
            encomendaBox.setManaged(false);
            mensagemVazia.setVisible(true);
            return;
        }

        encomendaAtual = encomenda;

        mensagemVazia.setVisible(false);
        encomendaBox.setVisible(true);
        encomendaBox.setManaged(true);

        labelDestinatario.setText("Destinatário: " + encomenda.getDestinatario());
        labelEndereco.setText("Endereço: " + encomenda.getDestinatario().getEndereco());
        labelCodigo.setText("Código de Rastreio: " + encomenda.getCodigoRastreio());

        if (encomenda.getImagem() != null) {
            imagemEncomenda.setImage(new Image("file:" + encomenda.getImagem()));
        }

        if (qrCodeBytes != null) {
            qrCodeImagem.setImage(new Image(new ByteArrayInputStream(qrCodeBytes)));
        }
    }

    @FXML
    private void enviarWhatsapp() {
        if (encomendaAtual != null) {
            System.out.println("Enviando WhatsApp para: " + encomendaAtual.getDestinatario());
            // Aqui você pode integrar com API ou abrir uma URL com o WhatsApp Web
        }
    }
}


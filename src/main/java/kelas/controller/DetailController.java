package kelas.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kelas.Navigator;
import kelas.model.Pembelian;

public class DetailController {
    @FXML private Label kodeLabel;
    @FXML private Label namaLabel;
    @FXML private Label jenisLabel;
    @FXML private Label jumlahLabel;
    @FXML private Label totalLabel;
    @FXML private Label pesanLabel;
    @FXML private ImageView gambarView;

    private Navigator navigator;

    public void setData(Navigator navigator, Pembelian pembelian) {
        this.navigator = navigator;
        kodeLabel.setText(pembelian.getKode());
        namaLabel.setText(pembelian.getTiket().getNamaPembeli());
        jenisLabel.setText(pembelian.getTiket().getJenis());

        NumberFormat rupiah = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
        String hargaFormatted = rupiah.format(pembelian.getTiket().hitungTotal());

        if (jumlahLabel != null) {
            jumlahLabel.setText(String.valueOf(pembelian.getTiket().getJumlah()));
        }
        totalLabel.setText(hargaFormatted);

        if (pembelian.getGambarUri() != null) {
            Image image = new Image(pembelian.getGambarUri(), 640, 480, true, true);
            if (image.isError()) {
                pesanLabel.setText("Lampiran gambar tidak dapat dibaca.");
            } else {
                gambarView.setImage(image);
                pesanLabel.setText("");
            }
        } else {
            pesanLabel.setText("Tanpa lampiran gambar produk.");
        }
    }

    @FXML
    private void tambahLagi() {
        try {
            navigator.bukaForm();
        } catch (IOException e) {
            pesanLabel.setText("Form gagal dibuka.");
            e.printStackTrace();
        }
    }

    @FXML
    private void bukaDaftar() {
        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            pesanLabel.setText("Daftar gagal dibuka.");
            e.printStackTrace();
        }
    }
}
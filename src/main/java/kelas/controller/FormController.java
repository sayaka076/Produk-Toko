package kelas.controller;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import kelas.Navigator;
import kelas.data.DataPembelian;
import kelas.model.Pembelian;
import kelas.model.Tiket;
import kelas.model.TiketMahasiswa;
import kelas.model.TiketReguler;

public class FormController {
    @FXML private TextField namaField;
    @FXML private TextField jumlahField;
    @FXML private ComboBox<String> jenisBox;
    @FXML private Label pesanLabel;
    @FXML private ImageView gambarView;

    private String gambarUri;
    private Navigator navigator;
    private DataPembelian data;

    @FXML
    private void initialize() {
        jenisBox.getItems().addAll("Makanan", "Minuman");
        jenisBox.setValue("Makanan");
    }

    public void setKonteks(Navigator navigator, DataPembelian data) {
        this.navigator = navigator;
        this.data = data;
    }

    @FXML
    private void simpan() {
        Pembelian pembelian;
        try {
            int harga = Integer.parseInt(jumlahField.getText().trim());
            Tiket produk;
            if ("Minuman".equals(jenisBox.getValue())) {
                produk = new TiketMahasiswa(namaField.getText(), harga);
            } else {
                produk = new TiketReguler(namaField.getText(), harga);
            }
            pembelian = data.tambah(produk, gambarUri);
        } catch (NumberFormatException e) {
            pesanLabel.setText("Harga produk harus berupa bilangan bulat positif.");
            return;
        } catch (IllegalArgumentException e) {
            pesanLabel.setText(e.getMessage());
            return;
        }

        try {
            navigator.bukaDetail(pembelian);
        } catch (IOException e) {
            data.hapus(pembelian);
            pesanLabel.setText("Detail gagal dibuka. Data dibatalkan.");
            e.printStackTrace();
        }
    }

    @FXML
    private void pilihGambar() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Pilih gambar produk lokal");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Gambar PNG/JPG/JPEG", "*.png", "*.jpg", "*.jpeg"));
        File file = chooser.showOpenDialog(namaField.getScene().getWindow());
        if (file == null) return;

        if (file.length() > 5L * 1024 * 1024) {
            pesanLabel.setText("Gambar maksimal 5 MB.");
            return;
        }
        Image image = new Image(file.toURI().toString(), 640, 480, true, true);
        if (image.isError()) {
            pesanLabel.setText("File gambar tidak dapat dibaca.");
            return;
        }
        gambarUri = file.toURI().toString();
        gambarView.setImage(image);
        pesanLabel.setText("Gambar produk berhasil dipilih.");
    }

    @FXML
    private void hapusGambar() {
        gambarUri = null;
        gambarView.setImage(null);
        pesanLabel.setText("Lampiran gambar dihapus.");
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
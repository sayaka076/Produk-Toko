package kelas.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.Pembelian;
import kelas.model.Tiket;

public class DataPembelian {
    private final ObservableList<Pembelian> daftar = FXCollections.observableArrayList();
    private int urutan = 1;

    public ObservableList<Pembelian> getDaftar() {
        return FXCollections.unmodifiableObservableList(daftar);
    }

    public Pembelian tambah(Tiket tiket, String gambarUri) {
        Pembelian p = new Pembelian(
                String.format("PRD%03d", urutan), tiket, gambarUri);
        daftar.add(p);
        urutan++;
        return p;
    }

    public void hapus(Pembelian pembelian) {
        daftar.remove(pembelian);
    }
}
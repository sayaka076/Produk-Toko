package kelas.model;

public class TiketMahasiswa extends Tiket {

    public TiketMahasiswa(String namaProduk, int harga) {
        super(namaProduk, harga);
    }

    @Override
    public long hitungTotal() {
        return (long) getJumlah();
    }

    @Override
    public String getJenis() {
        return "Minuman";
    }
}
package kelas.model;

public class TiketReguler extends Tiket {

    public TiketReguler(String namaProduk, int harga) {
        super(namaProduk, harga);
    }

    @Override
    public long hitungTotal() {
        return (long) getJumlah();
    }

    @Override
    public String getJenis() {
        return "Makanan";
    }
}
package kelas.model;

public abstract class Tiket {
    private final String namaPembeli; // Menyimpan Nama Produk
    private final int jumlah;         // Menyimpan Harga Produk (Rp)

    public Tiket(String namaPembeli, int jumlah) {
        if (namaPembeli == null || namaPembeli.isBlank()) {
            throw new IllegalArgumentException("Nama produk wajib diisi.");
        }
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Harga produk harus lebih dari nol.");
        }
        this.namaPembeli = namaPembeli.trim();
        this.jumlah = jumlah;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public int getJumlah() {
        return jumlah;
    }

    public abstract long hitungTotal();
    public abstract String getJenis();
}
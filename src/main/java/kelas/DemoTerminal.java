package kelas;

import kelas.model.Tiket;
import kelas.model.TiketMahasiswa;
import kelas.model.TiketReguler;

public class DemoTerminal {
    public static void main(String[] args) {
        Tiket produk = new TiketReguler("Nasi Goreng Spesial", 25000);
        System.out.println(produk.getNamaPembeli() + " - " + produk.getJenis());
        System.out.println(produk.hitungTotal());

        produk = new TiketMahasiswa("Es Teh Manis", 5000);
        System.out.println(produk.getNamaPembeli() + " - " + produk.getJenis());
        System.out.println(produk.hitungTotal());
    }
}
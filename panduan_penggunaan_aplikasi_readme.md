# Aplikasi Daftar Produk Toko (JavaFX)

Aplikasi **Daftar Produk Toko** adalah aplikasi desktop berbasis **JavaFX 21** dan **Maven** yang digunakan untuk mencatat, menampilkan, mencari, dan melihat detail data produk toko (kategori **Makanan** dan **Minuman**) beserta lampiran gambar produk (`.png`, `.jpg`, `.jpeg`). Data disimpan secara *in-memory* (di dalam RAM) selama aplikasi berjalan.

---

## 1. Prasyarat Sistem (Prerequisites)

Sebelum menjalankan program, pastikan komputer Anda telah terpasang:
* **Java Development Kit (JDK)**: Versi 17 atau lebih baru.
* **IDE**: Apache NetBeans IDE (disarankan versi 17 ke atas yang mendukung Maven).
* **Koneksi Internet**: Diperlukan saat pertama kali melakukan *build* agar Maven dapat mengunduh dependensi JavaFX 21 secara otomatis.

---

## 2. Cara Menjalankan Program di Apache NetBeans

1. Buka **Apache NetBeans IDE**.
2. Klik menu **File** $\rightarrow$ **Open Project...**, lalu pilih folder proyek **`TiketAppAdvanced`**.
3. Klik kanan pada nama proyek **`TiketAppAdvanced`** di panel **Projects**, kemudian pilih **Clean and Build** untuk mengompilasi seluruh kode sumber dan menyalin file `.fxml` serta `.css`.
4. Jalankan aplikasi dengan salah satu cara berikut:
   * Klik tombol **Run Project (F6)** pada toolbar NetBeans, atau
   * Melalui terminal bawaan NetBeans dengan menjalankan perintah:
     ```bash
     mvn clean javafx:run
     ```

---

## 3. Panduan Penggunaan Aplikasi

Aplikasi ini memiliki 3 halaman utama yang saling terhubung dalam satu jendela (*scene* berukuran $900 \times 680$ piksel):

### A. Menambahkan Produk Baru (Halaman Form)
Saat aplikasi pertama kali dijalankan, pengguna akan langsung diarahkan ke halaman **Pencatatan Produk Toko (Buat produk baru)**:
1. **Nama produk**: Ketikkan nama produk pada kolom input (contoh: `Nasi Goreng Spesial`). Kolom ini wajib diisi.
2. **Kategori produk**: Pilih kategori produk pada *dropdown* (`Makanan` atau `Minuman`).
3. **Harga produk (Rp)**: Masukkan harga satuan produk berupa angka bulat positif $> 0$ tanpa titik atau simbol mata uang (contoh: `25000`).
4. **Lampiran Gambar Produk (Opsional)**:
   * Klik tombol **Pilih Gambar** untuk membuka *File Explorer*.
   * Pilih file gambar berformat `.png`, `.jpg`, atau `.jpeg` dengan ukuran maksimal $5\text{ MB}$.
   * Gambar yang berhasil dipilih akan langsung tampil pada area *preview*.
   * Jika ingin membatalkan gambar yang sudah dipilih, klik tombol **Hapus Lampiran**.
5. **Menyimpan Data**:
   * Klik tombol **Simpan dan Lihat Detail**.
   * Sistem akan membuat kode produk secara otomatis (`PRD001`, `PRD002`, `PRD003`, dst.) dan langsung membuka halaman **Detail Produk**.
   * Apabila ingin langsung menuju tabel tanpa menambah produk, klik tombol **Lihat Daftar** di bagian atas halaman.

---

### B. Melihat Informasi Lengkap Produk (Halaman Detail)
Halaman **Detail Produk** menampilkan data dari objek produk yang baru saja disimpan atau yang dipilih dari tabel:
* Menampilkan **Kode Produk**, **Nama Produk**, **Kategori**, **Harga Produk** (otomatis diformat ke dalam mata uang Rupiah, misalnya `Rp25.000,00`), serta **Gambar Produk** jika tersedia.
* Klik tombol **Tambah Produk Lain** di bagian bawah untuk kembali ke halaman form dan menginput produk berikutnya.
* Klik tombol **Lihat Daftar** di bagian *header* atas untuk membuka halaman tabel seluruh produk.

---

### C. Mencari & Mengelola Produk (Halaman Daftar Produk)
Halaman **Daftar Produk Toko** menampilkan seluruh produk yang telah dicatat ke dalam tabel 4 kolom (**Kode**, **Nama Produk**, **Kategori**, dan **Harga (Rp)**):

1. **Mencari Produk berdasarkan Nama atau Kode**:
   * Ketikkan kata kunci nama produk atau kode produk pada kotak pencarian di bagian atas (contoh: `nasi` atau `PRD001`).
   * Pilih filter kategori pada *dropdown* di bawahnya (`Semua`, `Makanan`, atau `Minuman`).
   * Klik tombol **Cari** (atau tekan tombol `Enter` pada *keyboard*). Tabel akan menyaring data dan menampilkan jumlah produk yang sesuai di bagian bawah tabel.
   * Klik tombol **Reset** untuk mengosongkan kata kunci pencarian dan menampilkan seluruh produk kembali.
2. **Melihat Detail Produk dari Tabel**:
   * Klik salah satu baris produk pada tabel hingga baris tersebut terpilih (*highlighted*).
   * Klik tombol **Lihat Detail**. Aplikasi akan membuka halaman detail untuk produk yang dipilih tersebut.
3. **Menghapus Produk**:
   * Pilih salah satu baris produk pada tabel, lalu klik tombol **Hapus**.
   * Akan muncul kotak dialog konfirmasi (`Hapus produk PRD001?`). Pilih **Yes** untuk menghapus data atau **No** untuk membatalkan.
4. **Mengatur Tampilan Kolom Harga**:
   * Centang atau hilangkan centang pada kotak **Harga** untuk menampilkan atau menyembunyikan kolom `Harga (Rp)` pada tabel.
5. **Menambah Produk Baru dari Halaman Daftar**:
   * Klik tombol **Tambah** berwarna biru untuk kembali ke halaman form input produk.

---

## 4. Aturan Validasi Input

Aplikasi dilengkapi dengan validasi otomatis untuk mencegah masuknya data yang tidak valid:
* **Nama produk kosong**: Jika kolom nama produk dikosongkan atau hanya berisi spasi, penyimpanan akan ditolak dan muncul pesan kesalahan:
  > *"Nama produk wajib diisi."*
* **Harga produk bernilai $\le 0$**: Jika harga diisi `0` atau angka negatif (misalnya `-5000`), penyimpanan akan ditolak dan muncul pesan kesalahan:
  > *"Harga produk harus lebih dari nol."*
* **Harga produk bukan angka**: Jika kolom harga dikosongkan atau diisi huruf/simbol (misalnya `abc`), penyimpanan akan ditolak dan muncul pesan kesalahan:
  > *"Harga produk harus berupa bilangan bulat positif."*
* **Baris tabel belum dipilih**: Jika menekan tombol **Lihat Detail** atau **Hapus** tanpa memilih baris pada tabel terlebih dahulu, akan muncul pesan peringatan:
  > *"Pilih satu baris produk dahulu."*

---

## 5. Struktur File Proyek

Proyek ini mempertahankan struktur class asli dari modul praktikum dengan penyesuaian fungsi untuk manajemen produk toko:

```text
TiketAppAdvanced/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── kelas/
        │       ├── MainApp.java              # Entry point aplikasi JavaFX
        │       ├── Navigator.java            # Pengatur perpindahan halaman (Scene)
        │       ├── DemoTerminal.java         # Pengujian model melalui konsol/terminal
        │       ├── model/
        │       │   ├── Tiket.java            # Abstract class dasar atribut & validasi produk
        │       │   ├── TiketReguler.java     # Model untuk produk kategori Makanan
        │       │   ├── TiketMahasiswa.java   # Model untuk produk kategori Minuman
        │       │   └── Pembelian.java        # Entitas pencatatan produk (Kode, Produk, URI Gambar)
        │       ├── data/
        │       │   └── DataPembelian.java    # Penyimpanan daftar produk di memori (ObservableList)
        │       └── controller/
        │           ├── FormController.java   # Controller halaman form input produk & gambar
        │           ├── DetailController.java # Controller halaman detail produk
        │           └── DaftarController.java # Controller halaman tabel & pencarian produk
        └── resources/
            └── kelas/
                ├── form.fxml                 # Desain UI halaman form produk
                ├── detail.fxml               # Desain UI halaman detail produk
                ├── daftar.fxml               # Desain UI halaman daftar/tabel produk
                └── styles/
                    └── app.css               # Stylesheet CSS tampilan aplikasi
```
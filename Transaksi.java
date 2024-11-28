class Transaksi extends Barang {
    private String noFaktur;
    private String kasir;

    public Transaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, String kasir) {
        super(kodeBarang, namaBarang, hargaBarang);
        this.noFaktur = noFaktur;
        this.kasir = kasir;
    }

    public void tampilkanTransaksi(int jumlahBeli) {
        // Menghitung total harga berdasarkan jumlah beli
        double total = hitungTotal(jumlahBeli);
        System.out.println("\n+----------------------------------------------------+");
        // Menampilkan detail transaksi dengan format yang jelas
        System.out.println("No. Faktur      : " + noFaktur); // Menampilkan nomor faktur
        System.out.println("Kode Barang     : " + kodeBarang); // Menampilkan kode barang
        System.out.println("Nama Barang     : " + namaBarang); // Menampilkan nama barang
        System.out.println("Harga Barang    : Rp " + hargaBarang); // Menampilkan harga barang
        System.out.println("Jumlah Beli     : " + jumlahBeli); // Menampilkan jumlah beli
        System.out.println("TOTAL           : Rp " + total); // Menampilkan total harga
        System.out.println("+----------------------------------------------------+");
        System.out.println("Kasir           : " + kasir); // Menampilkan nama kasir
        System.out.println("+----------------------------------------------------+");
    }
}

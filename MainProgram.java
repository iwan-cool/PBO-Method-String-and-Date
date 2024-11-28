import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Login Section
            System.out.println("+-----------------------------------------------------+");
            System.out.println("                     LOGIN                            ");
            System.out.println("+-----------------------------------------------------+");

            String correctUsername = "ikhwan"; // Username yang valid
            String correctPassword = "12345"; // Password yang valid

            while (true) {
                System.out.print("Username : ");
                String username = scanner.nextLine(); // Input username dari pengguna
                if (username.isEmpty()) {
                    throw new InvalidInputException("Username tidak boleh kosong!");
                }

                System.out.print("Password : ");
                String password = scanner.nextLine(); // Input password dari pengguna
                if (password.isEmpty()) {
                    throw new InvalidInputException("Password tidak boleh kosong!");
                }

                // Captcha yang ditentukan
                String captcha = "LIV123"; 
                System.out.println("Captcha  : " + captcha);
                System.out.print("Masukkan Captcha : ");
                String captchaInput = scanner.nextLine(); // Input captcha dari pengguna

                // Validasi login
                if (username.equals(correctUsername) && password.equals(correctPassword) && captchaInput.equals(captcha)) {
                    System.out.println("Login berhasil!\n");
                    break;
                } else {
                    System.out.println("Login gagal, silakan coba lagi.\n");
                }
            }

            // Welcome Message with Date and Time
            System.out.println("Selamat Datang di AnfieldMart");

            // Menampilkan tanggal dan waktu saat ini
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss"); 
            // Format tanggal dan waktu: Hari, Tanggal Bulan Tahun Jam:Menit:Detik
            System.out.println("Tanggal dan Waktu : " + sdf.format(new Date())); // Menggunakan objek `Date` untuk mendapatkan waktu saat ini
            System.out.println("+----------------------------------------------------+");

            // Input Details
            System.out.print("Masukkan Nama Kasir: ");
            String kasir = scanner.nextLine(); // Input nama kasir
            if (kasir.isEmpty()) {
                throw new InvalidInputException("Nama Kasir tidak boleh kosong!");
            }

            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine(); // Input nomor faktur
            if (noFaktur.isEmpty()) {
                throw new InvalidInputException("No Faktur tidak boleh kosong!");
            }

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine(); // Input kode barang
            if (kodeBarang.isEmpty()) {
                throw new InvalidInputException("Kode Barang tidak boleh kosong!");
            }

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine(); // Input nama barang
            if (namaBarang.isEmpty()) {
                throw new InvalidInputException("Nama Barang tidak boleh kosong!");
            }

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble(); // Input harga barang
            if (hargaBarang <= 0) {
                throw new InvalidInputException("Harga Barang harus lebih dari 0!");
            }

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = scanner.nextInt(); // Input jumlah beli
            if (jumlahBeli <= 0) {
                throw new InvalidInputException("Jumlah Beli harus lebih dari 0!");
            }

            // Membuat objek transaksi dan menampilkan hasil
            Transaksi transaksi = new Transaksi(noFaktur, kodeBarang, namaBarang, hargaBarang, kasir);
            transaksi.tampilkanTransaksi(jumlahBeli);

        } catch (InvalidInputException e) {
            // Menangani input yang tidak valid
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            // Menangani kesalahan lainnya
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close(); // Menutup Scanner untuk menghindari kebocoran resource
        }
    }
}
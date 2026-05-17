import java.util.ArrayList;
public class App {    public static void main(String[] args) {
        Pembayaran pembayaran1 = new KartuKredit("Razqa", 450000,"1234-5678-9999");

        Pembayaran pembayaran2 = new Ewallet("Rizky Simanjuntak", 250000, "08123456789");

        ArrayList<Pembayaran> daftarPembayaran = new ArrayList<>();
        daftarPembayaran.add(pembayaran1);
        daftarPembayaran.add(pembayaran2);

        for (Pembayaran pembayaran : daftarPembayaran) {
            System.out.println("==================================");
            pembayaran.tampilkanDetail();

            if (pembayaran instanceof Keamanan) {
                Keamanan keamanan = (Keamanan) pembayaran;
                if (keamanan.autentikasi()) {
                    pembayaran.prosesPembayaran();
                }
            }

            System.out.println("==================================\n");
        }
    }
}

public class Ewallet extends Pembayaran implements Keamanan {
    private String nomorEwallet;

    public Ewallet(String namaPembayar, double nominal, String nomorEwallet) {
        super(namaPembayar, nominal);
        this.nomorEwallet = nomorEwallet;
    }

    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi OTP berhasil.");
        return true;
    }

    @Override
    public void prosesPembayaran() {
        System.out.println("Metode Pembayaran : E-Wallet");
        System.out.println("Nomor E-wallet    : " + nomorEwallet);
        System.out.println("Total Tagihan     : Rp " + nominal);
    }
}

public class KartuKredit extends Pembayaran implements Keamanan {

    private String nomorKartu; //Atribut tambahan untuk Kartu Kredit

    //Constructor
    public KartuKredit(String namaPembayar, double nominal, String nomorKartu) {
        super(namaPembayar, nominal);
        this.nomorKartu = nomorKartu;
    }

    //Implementasi interface
    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi PIN berhasil.");
        return true;
    }

    //Implementasi abstract method
    @Override
    public void prosesPembayaran() {

        double biayaAdmin = nominal * 0.02;
        double totalTagihan = nominal + biayaAdmin;

        System.out.println("Metode Pembayaran : Kartu Kredit");
        System.out.println("Nomor Kartu: " + nomorKartu);
        System.out.println("Biaya Admin: Rp " + biayaAdmin);
        System.out.println("Total Tagihan: Rp " + totalTagihan);
    }
}
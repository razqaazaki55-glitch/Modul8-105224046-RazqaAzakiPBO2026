public class PengirimanDarat extends LayananPengiriman implements LacakKargo {
    private String jenisTruk;
    private String statusSaatIni;

    public PengirimanDarat(String noResi, double beratBarang, double jarakTempuh, String jenisTruk) {
        super(noResi, beratBarang, jarakTempuh);
        this.jenisTruk = jenisTruk;
        this.statusSaatIni = "Menunggu Kurir";
    }

    @Override
    public double hitungOngkosKirim(){
        double ongkosKirim = (beratBarang * 5000) + (jarakTempuh * 2000);

        if(jenisTruk.equalsIgnoreCase("Troton")){
            ongkosKirim = ongkosKirim + 150000; 
        }

        return ongkosKirim;
    }

    @Override 
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return statusSaatIni;
    }
}

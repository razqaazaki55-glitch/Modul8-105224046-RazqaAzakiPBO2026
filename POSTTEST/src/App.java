public class App {
    public static void main(String[] args) throws Exception {
        //Membuat objek Pengiriman Darat
        PengirimanDarat pengirimanDarat1 = new PengirimanDarat("DRT-001", 50.0, 100.0, "Troton");
        //Membuat objek Pengiriman Udara
        PengirimanUdara pengirimanUdara1 = new PengirimanUdara( "UDR-999", 10.0, 800.0, "GA-123", 5000000.0);
        //Update status Pengiriman Darat
        pengirimanDarat1.updateStatus("Sedang di jalan tol Cipali.");
        //Update status Pengiriman Udara
        pengirimanUdara1.updateStatus("Transit di Bandara Soekarno-Hatta.");
        //Menyimpan kedua objek ke dalam array polymorphism
        LayananPengiriman[] daftarPengiriman = new LayananPengiriman[2];
        daftarPengiriman[0] = pengirimanDarat1;
        daftarPengiriman[1] = pengirimanUdara1;
        
        System.out.println("=====================");
        System.out.println("SISTEM LOGISTIK-PRO");
        System.out.println("=====================");

        // Perulangan pada array polymorphism
        for (LayananPengiriman layanan : daftarPengiriman) {
            System.out.println("------------------------------------------------------------");
 
            //Memanggil cetakResi()
            layanan.cetakResi();
 
            //Mengecek lokasi terakhir dengan casting polimorfik ke LacakKargo
            if (layanan instanceof LacakKargo) {
                LacakKargo lacak = (LacakKargo) layanan;
                System.out.println("Lokasi Terakhir: " + lacak.cekLokasiTerakhir());
            }
 
            //Menghitung ongkos kirim dasar
            double ongkosKirim = layanan.hitungOngkosKirim();
            System.out.printf("Ongkos Kirim: Rp %,.0f%n", ongkosKirim);
 
            double totalTagihan = ongkosKirim;
 
            System.out.println("------------------------------------------------------------");
 
            //Deteksi fasilitas asuransi menggunakan instanceof
            if (layanan instanceof Asuransi) {
                Asuransi asuransi = (Asuransi) layanan;
 
                //Panggil cetakPolis()
                asuransi.cetakPolis();
 
                //Casting ke PengirimanUdara untuk mendapatkan nilaiBarang,
                //lalu hitung premi dan tambahkan ke total tagihan
                PengirimanUdara udara = (PengirimanUdara) layanan;
                double premi = asuransi.hitungPremi(udara.getNilaiBarang());
                System.out.printf("Premi Asuransi : Rp %,.0f%n", premi);
 
                totalTagihan = totalTagihan + premi;
            } else {
                System.out.println("Asuransi : Tidak tersedia untuk jalur ini.");
            }
 
            System.out.println("------------------------------------------------------------");
            System.out.printf("TOTAL TAGIHAN : Rp %,.0f%n", totalTagihan);
            System.out.println("============================================================");
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Programmer p = new Programmer("Budi", 5000000);
        System.out.println("Nama: " + p.nama);
        System.out.println("Gaji: " + p.hitungGaji());
    }
}

public abstract class Pembayaran {

    protected String namaPembayar;
    protected double nominal;

    // Constructor
    public Pembayaran(String namaPembayar, double nominal) {
        this.namaPembayar = namaPembayar;
        this.nominal = nominal;
    }

    // Concrete Method
    public void tampilkanDetail() {
        System.out.println("Nama Pembayar : " + namaPembayar);
        System.out.println("Nominal       : Rp " + nominal);
    }

    // Abstract Method
    public abstract void prosesPembayaran();
}
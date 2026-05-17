package com.rpg.arena;
//Kelas abstrak karakter mengimplementasikan interface aksi bertarung.
public abstract class Karakter implements AksiBertarung {
    //Atribut dengan access modifier protected agar bisa dikases oleh subclass
    protected String nama; //Nama karakter
    protected int hp; //Health Points karakter
    protected int baseDamage; //Damage karakter
    protected boolean isDefending; //Status karakter

    //Getter
    //Mengembalikan nilai nama karakter
    public String getNama(){
        return nama;
    }
    //Mengembalikan nilai hp karakter
    public int getHp(){
        return hp;
    }
    //Mengembalikan nilai Damage karakter
    public int getBaseDamage(){
        return baseDamage;
    }
    //Mengembalikan nilai status karakter
    public boolean IsDefending(){
        return isDefending;
    }

    //Setter
    //Mengubah nilai nama karakter
    public void setNama(String nama){
        this.nama = nama;
    }
    //Mengubah nilai hp karakter
    public void setBaseDamage(int baseDamage){
        this.baseDamage = baseDamage;
    }
    //Mengubah nilai status karakter
    public void setHp(int hp){
        this.hp = hp;
    }
    //Mengubah nilai status karakter
    public void setIsDefending(boolean isDefending){
        this.isDefending = isDefending;
    }
    //Constructor untuk menginisialisasi nama, hp, dan baseDamage
    public Karakter(String nama, int hp, int baseDamage) {
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false;
    }
    //Method ini digunakan untuk memproses damage yang diterima oleh karakter.
    //Jika karakter dalam keadaan bertahan, maka damage yang diterima akan dikurangi setengahnya.
    //Setelah itu, hp karakter akan dikurangi dengan damage yang diterima. Jika hp kurang dari 0, maka hp akan diatur menjadi 0.
    public void damageYangDiterima(int damage){
        //Kondisi untuk mengecek karakter sedang bertahan atau tidak.
        if(isDefending == true){
            damage = damage / 2; //Jika karakter bertahan, maka damage yang diterima akan dikurangi setengahnya.
            System.out.println(nama + " Berhasil mengurangi damage.");
            isDefending = false;
        }

        hp = hp - damage; //Hp karakter akan dikurangi dengan damage yang diterima.
        //Jika hp kurang dari 0, maka hp akan diatur otomatis menjadi 0.
        if(hp < 0){
            hp = 0;
        }

        System.out.println(nama + " Menerima damage sebesar " + damage + ". HP sekarang tersisa: " + hp);
    }

    //Method abstrak tampilkan Status
    public abstract void tampilkanStatus(); 
}

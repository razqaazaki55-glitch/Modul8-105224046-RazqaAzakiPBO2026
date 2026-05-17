package com.rpg.entitas;
import com.rpg.arena.Karakter;
//Kelas Monster mewarisi kelas abstrak karakter 
public class Monster extends Karakter {
    //Atribut tambahan untuk jenis monster
    private String jenisMonster;
    
    //Constructor untuk menginisialisasi atribut monster
    public Monster(String nama, int hp, int baseDamage, String jenisMonster) {
        super(nama, hp, baseDamage); //Memanggil constructor dari kelas karakter untuk menginisialisasi nama, hp, dan baseDamage
        this.jenisMonster = jenisMonster;
    }
    //Override method serang
    @Override
    public int serang(){
        //Monster menyerang menggunakan baseDamage
        System.out.println(nama + " Melakukan Penyerangan. Damage yang dikenakan sebesar: " + baseDamage);
        return baseDamage;
    }
    //Override method bertahan
    @Override 
    public void bertahan(){
        //Monster memulihkan HP sebesar setengah dari baseDamage ketika bertahan 
        int pulih = baseDamage / 2;
        hp = hp + pulih; //HP monster akan bertambah sebesar nilai pulih
        System.out.println(nama + " memulihkan HP " + pulih + ". HP sekarang: " + hp);
    }
    //Override method gunakanItem
    @Override
    public void gunakanItem(){
        System.out.println(" " + nama + " Tidak dapat menggunakan item.");
    }
    //Override method tampilkanStatus
    @Override
    //Menampilkan status nama, hp, dan jenis monster
    public void tampilkanStatus() {
        System.out.println("===============");
        System.out.println("Nama: " + nama);
        System.out.println("HP: " + hp);
        System.out.println("Jenis: " + jenisMonster);
        System.out.println("===============");
    }
}

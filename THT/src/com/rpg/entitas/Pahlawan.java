package com.rpg.entitas;
import com.rpg.arena.Karakter;
//Kelas pahlawan mewarisi kelas abstrak karakter
public class Pahlawan extends Karakter {
    //Atribut tambahan untuk pahlawan
    private int mana;
    private int level;
    //Constructor untuk menginisialisasi atribut pahlawan
    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) {
        super(nama, hp, baseDamage); //Memanggil constructor dari kelas karakter untuk menginisialisasi nama, hp, dan baseDamage
        this.mana = mana;
        this.level = level;
    }

    //Getter
    //Mengembalikan nilai mana pahlawan
    public int getMana(){
        return mana;
    }
    //Mengembalikan nilai level pahlawan
    public int getLevel(){
        return level;
    }

    //Setter
    //Mengubah nilai mana pahlawan
    public void setMana(int mana){
        this.mana = mana;
    }
    //Mengubah nilai level pahlawan 
    public void setLevel(int level){
        this.level = level;
    }
    //Override method serang
    @Override
    public int serang(){
        int damage = baseDamage * level; //Damage akan dihitung dari baseDamage dikalikan dengan level pahlawan
        System.out.println(nama + " Melakukan Penyerangan. Damage yang dikenakan sebesar: " + damage);
        return damage; 
    }
    //Override method bertahan
    @Override
    public void bertahan(){
        isDefending = true; //Karakter jika menghidupkan mode bertahan, maka status akan berubah menjadi true 
        System.out.println(nama + " bersiaga."); //Dan akan menampilkan pesan pahlawan besiaga
    }
    //Override method gunakanItem
    @Override
    public void gunakanItem(){
        hp = hp + 30; //Jika pahlawan menggunakan item, maka pahlawan akan memulihkan HP sebesar 30
        System.out.println("" + nama + " menggunakan item penyembuh. HP bertambah menjadi: " + hp);
    }
  
    @Override
    //Menampilkan status hp, mana, dan level pahlawan
    public void tampilkanStatus(){
        System.out.println("===============");
        System.out.println("HP: " + hp);
        System.out.println("Mana: " + mana);
        System.out.println("Level: " + level);
        System.out.println("===============");
    }

    //Overloading
    public int serang(String namaSkill, int manaCost){
        if(mana > manaCost){
            mana = mana - manaCost; //Jika pahlawan menggunakan skill, maka mana pahlawan akan berkurang sesuai dengan manaCost yang telah ditentukan
            int damage = baseDamage * level * 2; //Damage yang dihasilkan lebih besar dari serangan biasa.
            System.out.println(nama + " Menggunakan Skill " + namaSkill + ". Damage yang dikenakan sebesar: " + damage);
            return damage;
        } else {
            System.out.println("Gagal.");
        }
        return 0;
    }  
}

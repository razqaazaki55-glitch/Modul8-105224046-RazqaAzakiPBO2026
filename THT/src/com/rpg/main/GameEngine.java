package com.rpg.main;
import com.rpg.entitas.Monster;
import com.rpg.entitas.Pahlawan;
//library untuk input dari user
import java.util.Scanner;
 
public class GameEngine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //User diminta untuk menginput nama pahlawan
        System.out.println("Masukkan nama pahlawan: ");
        String namaPahlawan = input.nextLine();
        //Membuat objek pahlawan dan array monster
        Pahlawan pahlawan1 = new Pahlawan(namaPahlawan, 100, 10, 50, 1);
        //Disini kita akan membuat array 3 jenis monster yang berbeda. Parameter nya berisi nama, hp, baseDamage, dan jenis monster
        Monster[] arrayMonster = {
            new Monster("Goblin", 80, 8, "Goblin"),
            new Monster("Orc", 120, 12, "Orc"),
            new Monster("Troll", 150, 15, "Troll")
        };
        //Melakukan perulangan untuk setiap monster yang berada didalam arraymonster secara berurutan
        for (Monster monster : arrayMonster) {
            System.out.println("Monster Muncul: " + monster.getNama());
            //Melakukan perulangan selama hp pahlawan > 0 dan hp monster > 0
            while (pahlawan1.getHp() > 0 && monster.getHp() > 0) {
                //Menampilkan menu pilihan aksi
                System.out.println("==============");
                System.out.println("Pilih 3 opsi");
                System.out.println("1. Serang: ");
                System.out.println("2. Skill: ");
                System.out.println("3. Bertahan/Heal: ");
                System.out.println("==============");
                System.out.print("Pilihan : ");
                int pilihan = input.nextInt();
                input.nextLine(); 
                System.out.println("\t");
 
                int damagePahlawan = 0; //Variabel ini digunakan untuk menyimpan nilai damage yang dikenakan oleh pahlawan
 
                switch (pilihan) {
                    //Jika user memilih opsi 1, maka akan memanggil method serang dan mengembalikan nilai damage yang dikenakan ke monster
                    case 1:
                        damagePahlawan = pahlawan1.serang();
                        monster.damageYangDiterima(damagePahlawan); 
                        break;
                    //Jika user memilih opsi 2, maka akan memanggil overloading method serang dengan parameter nama skill dan mana cost
                    case 2:
                        damagePahlawan = pahlawan1.serang("Fire Slash", 20);
                        //Jika skill berhasil memberikan damage ke monster, maka damage terebut akan mengurangi hp monster dengan memanggil method damageYangDiterima pada monster.
                        if (damagePahlawan > 0) {
                            monster.damageYangDiterima(damagePahlawan);
                        }
                        break;
                    //Jika user memilih opsi 3, maka akan ditampilkan pilihanuntuk bertahan atau heal
                    case 3:
                        System.out.println("A. Bertahan");
                        System.out.println("B. Heal");
                        System.out.print("Pilih : ");
                        String aksi = input.nextLine().toUpperCase(); //Ubah ke uppercase untuk memudahkan pengecekan, tidak mementingkan huruf besar atau kecil
                        //Jika user memilih bertahan, maka akan Damage dari monster berikutnya akan dikurangi setengah
                        if (aksi.equals("A")) {
                            pahlawan1.bertahan(); 
                        //Jika user memilih heal, maka hp pahlawan akan bertamah sebesar 30
                        } else if (aksi.equals("B")) {
                            pahlawan1.gunakanItem();
                            System.out.println(namaPahlawan + " menggunakan item! HP: " + pahlawan1.getHp());
                        } else {
                            System.out.println("Pilihan tidak sah");
                        }
                        break;
                    default:
                        //Kode program ini dilakukan jika user menginput tidak sesuai dengan pilihan yang tersedia
                        System.out.println("Pilihan tidak sah");
                        continue;
                }
 
                //Kondisi untuk mengecek apakah monster sudah setelah menerima damage dari pahlawan
                if (monster.getHp() <= 0) {
                    System.out.println("\n" + monster.getNama() + " berhasil dikalahkan.");
                    break;
                }
 
                //Giliran monster menyerang
                System.out.println("\n=== GILIRAN MONSTER ===");
                int damageMonster = monster.serang(); //Monster menyerang dan mengembalikan nilai damage yang dikenakan ke pahlawan
                pahlawan1.damageYangDiterima(damageMonster); //Damage yang dikenakan oleh pahlawan
                System.out.println("\t");
 
                //Kondisi untuk mengecek apakah pahlawan sudah kalah setelah menerima serangan dari monster
                if (pahlawan1.getHp() <= 0) {
                    System.out.println("\n" + pahlawan1.getNama() + " sudah kalah.");
                    break;
                }
            }
            //Kondisi untuk mengecek jika pahlawan sudah kalah, maka akan keluar dari perulangan
            if (pahlawan1.getHp() <= 0) {
                break;
            }
        }
 
        // Hasil akhir game
        //Jika Hp pahlawan masih > 0 setelah semua monster dikalahkan, maka akan menampilkan Victory, jika tidak maka akan menampilkan Game Over
        System.out.println("\n===========================");
        if (pahlawan1.getHp() > 0) {
            System.out.println("VICTORY");
            System.out.println(namaPahlawan + " berhasil menyelesaikan pertandingan.");
        } else {
            System.out.println("GAME OVER");
        }
        System.out.println("===========================");
 
        input.close(); //Menutup scanner setelah selesai digunakan
    }
}
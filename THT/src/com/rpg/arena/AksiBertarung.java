package com.rpg.arena;
//Interface aksi dasar bertarung
public interface AksiBertarung {
    //Method untuk menyerang, nantinya akan mengembalikan nilai damage yang dikenakan kepada musuh.
    int serang();
    //Method untuk bertahan dari serangan musuh
    void bertahan();
    //Method untuk menggunakan item
    public void gunakanItem();
}
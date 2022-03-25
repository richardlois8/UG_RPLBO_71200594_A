package com.ug7.game;

public class Penyihir extends Karakter{
    private boolean isAbilityReady;

    public Penyihir(Player player) {
        super(player);
    }
    public void buyWeapon(int weapon){
        System.out.println("Daftar senjata:\n1. Pisau\n2. Tongkat Sihir\n3. Tongkat\n4. Katana");
        System.out.println("Pilihan senjata: " + weapon);
        if(weapon == 1 || weapon == 4){
            System.out.println("Sebagai ninja kamu hanya boleh membeli tongkat/tongkat sihir!");
        }
        else{
            super.buyWeapon(weapon);
        }
    }

    @Override
    public void abilityAttack(Karakter karakter) {
       int heal = 0;
        if(this.isAbilityReady){
            if (this.isWalk()){
                heal =karakter.getHP()/2;
            }
            else{
                heal = 100;
            }
            super.setHP((int) (super.getHP()+heal));
            System.out.println("Tidak semudah itu, "+karakter.getPlayer().getUsername()+"!");
            System.out.println("HP Sekarang : "+this.getHP());
            System.out.println(karakter.getPlayer().getUsername() + " terkena serangan! Sisa HP " + karakter.getPlayer().getUsername() + ": " + karakter.getHP());
            if (this.getHP() <= 0){
                System.out.println(karakter.getPlayer().getUsername() + " mati!");
                this.getPlayer().levelUp();
            }
        }
        else {
            System.out.println("Ability belum aktif!");
        }
    }

    @Override
    public void normalAttack(Karakter karakter) {
        if (this.getWeapon() != 0) {
            if (super.isWalk()) {
                int damageWeapon = 0;
                if (super.getWeapon() == 1) {
                    damageWeapon = 20;
                } else if (super.getWeapon() == 2) {
                    damageWeapon = 60;
                } else if (super.getWeapon() == 3) {
                    damageWeapon = 25;
                } else if (super.getWeapon() == 4) {
                    damageWeapon = 50;
                }
                int karakterHP = karakter.getHP();
                int damageHP = (int) (karakter.getHP() - (damageWeapon * 1.5));
                karakter.setHP(karakterHP - damageHP);
                System.out.println(karakter.getPlayer().getUsername() + " terkena serangan! Sisa HP " + karakter.getPlayer().getUsername() + ": " + karakter.getHP());
                if (karakter.getHP() <= 0) {
                    super.getPlayer().levelUp();
                    System.out.println(karakter.getPlayer().getUsername() + " mati!");
                }
                if (karakter.getHP() < 50) {
                    this.isAbilityReady = true;
                }
            }
            else {
                super.normalAttack(karakter);
            }
        }
        else {
                System.out.println("Maaf, " + this.getPlayer().getUsername() + "... Silakan beli senjata terlebih dahulu!");
            }
    }

    public void walk(boolean type) {
        if(!type){
            System.out.println(super.getPlayer().getUsername()+" terbang! (Lari)");
        }
        super.walk(type);
    }

    @Override
    public void getInfo() {
        System.out.println("[Karakter Penyihir]");
        super.getInfo();
    }

}

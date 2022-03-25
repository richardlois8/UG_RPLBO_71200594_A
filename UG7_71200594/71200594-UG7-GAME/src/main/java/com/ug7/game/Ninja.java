package com.ug7.game;

public class Ninja extends Karakter{
    private boolean isAbilityReady;

    public Ninja(Player player){
        super(player);
    }

    public void buyWeapon(int weapon){
        System.out.println("Daftar senjata:\n1. Pisau\n2. Tongkat Sihir\n3. Tongkat\n4. Katana");
        System.out.println("Pilihan senjata: " + weapon);
        if(weapon == 2 || weapon == 3){
            System.out.println("Sebagai ninja kamu hanya boleh membeli pisau/katana!");
        }
        else{
            super.buyWeapon(weapon);
        }
    }

    @Override
    public void abilityAttack(Karakter karakter) {
        int damageAblt = 0;
        if(this.isAbilityReady){
            if (!super.isWalk()){
                damageAblt = (int) karakter.getHP();
            }
            else{
                damageAblt = (int) (karakter.getHP()/2);
            }
            karakter.setHP(karakter.getHP()-damageAblt);
            System.out.println("Rasakan ini, "+karakter.getPlayer().getUsername()+"!");
            System.out.println(karakter.getPlayer().getUsername() + " terkena serangan! Sisa HP " + karakter.getPlayer().getUsername() + ": " + karakter.getHP());
            if (karakter.getHP() <= 0){
                System.out.println(karakter.getPlayer().getUsername() + " mati!");
                this.getPlayer().levelUp();
            }
        }
        else{
            System.out.println("Ability belum aktif!");
        }
    }

    @Override
    public void normalAttack(Karakter karakter) {
        if(this.getWeapon() != 0){
            if (!super.isWalk()){
                int damageWeapon = 0;
                if (super.getWeapon() == 1){
                    damageWeapon = 20;
                }
                else if (super.getWeapon() == 2){
                    damageWeapon = 60;
                }
                else if (super.getWeapon() == 3){
                    damageWeapon = 25;
                }
                else if (super.getWeapon() == 4){
                    damageWeapon = 50;
                }
                int damageHP = (int) (karakter.getHP()-(damageWeapon * 1.5));
                karakter.setHP(damageHP);
                System.out.println(karakter.getPlayer().getUsername() + " terkena serangan! Sisa HP " + karakter.getPlayer().getUsername() + ": " + karakter.getHP());
                if (karakter.getHP() <= 0){
                    super.getPlayer().levelUp();
                    System.out.println(this.getPlayer().getUsername() + " mati!");
                }
                if (karakter.getHP() < 50){
                    this.isAbilityReady = true;
                }
            }
            else{
                super.normalAttack(karakter);
            }
        }
        else{
            System.out.println("Maaf, "+this.getPlayer().getUsername()+"... Silakan beli senjata terlebih dahulu!");
        }
    }

    public void walk(boolean type) {
        if(type == false){
            System.out.println(super.getPlayer().getUsername()+" menghilang! (Lari)");
        }
        super.walk(type);
    }

    @Override
    public void getInfo() {
        System.out.println("[Karakter Ninja]");
        super.getInfo();
    }
}

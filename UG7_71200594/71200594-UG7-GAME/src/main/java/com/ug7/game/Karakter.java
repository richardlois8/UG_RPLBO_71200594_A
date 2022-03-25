package com.ug7.game;

public class Karakter {
    private Player player;
    private int HP;
    private int money;
    private int weapon;
    private boolean isWalk;

    public Karakter(Player player) {
        this.player = player;
        this.HP = 100;
        this.money = 5000;
        this.weapon = 0;
        this.isWalk = false;
    }

    public void buyWeapon(int weapon){
        int hargaWeapon = 0;
        if (weapon == 1){
            hargaWeapon = 500;
        }
        else if(weapon == 2){
            hargaWeapon = 3000;
        }
        else if(weapon == 3){
            hargaWeapon = 2000;
        }
        else if(weapon == 4){
            hargaWeapon = 4000;
        }
        else{
            System.out.println("Pilihan yang kamu masukkan salah!");
        }

        if(this.money < hargaWeapon){
            System.out.println("Maaf uang kamu tidak mencukupi!");
        }
        else{
            this.money -= hargaWeapon;
            this.weapon = weapon;
            System.out.println("Berhasil membeli senjata! Uang sekarang: " + this.getMoney());
        }
    }

    public void abilityAttack(Karakter karakter){
        System.out.println(karakter.getPlayer().getUsername() + " terkena serangan! Sisa HP " + karakter.getPlayer().getUsername() + ": " + this.getHP());
        if (this.getHP() <= 0){
            System.out.println(this.getPlayer().getUsername() + " mati!");
        }
    }

    public void normalAttack(Karakter karakter){
        int damageWeapon = 0;
        if (this.getWeapon() == 1){
            damageWeapon = 20;
        }
        else if (this.getWeapon() == 2){
            damageWeapon = 60;
        }
        else if (this.getWeapon() == 3){
            damageWeapon = 25;
        }
        else if (this.getWeapon() == 4){
            damageWeapon = 50;
        }
        karakter.HP -= damageWeapon;
        System.out.println(karakter.getPlayer().getUsername() + " terkena serangan! Sisa HP " + karakter.getPlayer().getUsername() + ": " + karakter.getHP());
        if (karakter.getHP() <= 0){
            System.out.println(karakter.getPlayer().getUsername() + " mati!");
        }
    }

    public void walk(Boolean type){
        this.setIsWalk(type);
    }

    public void getInfo(){
        System.out.println("Username : "+this.getPlayer().getUsername());
        System.out.println("Level : "+this.getPlayer().getLevel());
        System.out.println("Money : "+this.getMoney());
        System.out.println("HP : "+(this.getHP() > 0 ? this.getHP() : "[Mati]"));
        String namaWeapon = "";
        if (weapon == 0){
            namaWeapon = "Tangan Kosong";
        }
        else if (weapon == 1){
            namaWeapon = "Pisau";
        }
        else if(weapon == 2){
            namaWeapon = "Tongkat Sihir";
        }
        else if(weapon == 3){
            namaWeapon = "Tongkat";
        }
        else if(weapon == 4){
            namaWeapon = "Katana";
        }
        System.out.println("Weapon : "+namaWeapon);
        System.out.println("Movement : "+(this.isWalk() ? "Berjalan" : "Berlari")+"\n");
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getHP() {
        return this.HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getWeapon() {
        return this.weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public boolean isWalk() {
        return this.isWalk;
    }

    public void setIsWalk(boolean walk) {
        isWalk = walk;
    }
}

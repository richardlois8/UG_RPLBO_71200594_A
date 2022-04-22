package com.ug8.soal1;

public abstract class Character {
    protected int damage;
    protected String name;
    protected int health;

    public Character(String name, int health,int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void attacked(int damage){
        this.health -= damage;
    }

    public void showCharacterInfo(){
        System.out.println("Hero\t: "+this.getName());
        System.out.println("Health\t: "+this.getHealth());
        System.out.println("Damage\t: "+this.getDamage());
    }

    public boolean isDie(){
        return this.getHealth() <= 0;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}

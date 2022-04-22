package com.ug8.soal1;

public class Creep extends Character{
    public Creep(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void attack(Hero hero){
        hero.attacked(this.getDamage());
    }


}

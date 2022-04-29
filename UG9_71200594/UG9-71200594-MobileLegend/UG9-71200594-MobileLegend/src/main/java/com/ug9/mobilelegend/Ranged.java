package com.ug9.mobilelegend;

public class Ranged extends Hero implements Skill{
    public Ranged(String name, int damage, int health) {
        super(name, damage, health);
    }

    @Override
    public void ultimate() {
        super.addDamage(150);
        System.out.println(this.getName() + " mengaktifkan ulti. Damage saat ini bertambah 150.");
    }

    @Override
    public void attack(Character enemy) {
        if(enemy instanceof Minion) super.setHealthBonus(150);
        super.attack(enemy);
    }


}

package com.ug9.mobilelegend;

public class Hero extends Character{
    private int healthBonus;
    private int level = 1;
    private int healthMax;
    private int lifeSteal = 50;

    public Hero(String name, int damage, int health) {
        super(name, damage, health);
        this.healthMax = health;
    }

    public void addDamage(int damage){
        super.setDamage(this.getDamage()+damage);
    }

    @Override
    public void attack(Character enemy) {
        if (enemy.getHealth() <= 0) System.out.println("Nyawa negatif");
        else {
            int totalHealth = enemy.getHealth()-this.getDamage();
            if(totalHealth < 0) enemy.setHealth(0);
            else enemy.setHealth(totalHealth);
            if (enemy.getHealth() == 0) enemy.setDie(true);
            if (enemy.isDie()){
                this.level += 1;
                if(enemy instanceof Melee || enemy instanceof Ranged){
                    this.lifeSteal += 150;
//                    super.setHealth(super.getHealth()+this.lifeSteal);
                }
                else if (enemy instanceof Minion || enemy instanceof Creep) {
                    int tambahanHealth = super.getHealth()+this.healthBonus;
                    if (tambahanHealth <= this.healthMax) this.setHealth(tambahanHealth);
                    else this.setHealth(this.healthMax);
//                    tambahan life steal basic
//                    super.setHealth(super.getHealth()+50);
                }
            }
            int totalAkhirHealth = super.getHealth()+this.lifeSteal;
            if (totalAkhirHealth <= this.healthMax) this.setHealth(totalAkhirHealth);
            else this.setHealth(this.healthMax);

            this.lifeSteal = 50;
            this.healthBonus = 0;
            attackInformation(enemy,this.getDamage());
        }
    }

    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }

    public int getLevel() {
        return level;
    }
}

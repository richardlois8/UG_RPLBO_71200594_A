package com.ug8.soal1;

public class Golem extends SummonCharacter implements Summoner{
    private int kill;

    public Golem(Summoner owner) {
        super("Golem",1000,120,owner);
    }

    public void attack(Creep creep){
        creep.attacked(this.getDamage());
        if(creep.isDie()){
            this.kill += 1;
        }
    }

    public Golem summon(){
        if(this.getKill() > 0){
            this.kill -= 1;
            return new Golem(this);
        }
        return null;
    }

    public int getKill() {
        return kill;
    }
}

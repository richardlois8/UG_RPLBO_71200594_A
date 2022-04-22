package com.ug8.soal1;

public class Warlock extends Hero implements Summoner{
    private int numOfSummon;

    public Warlock() {
        super("Warlock",700,80);
    }

    @Override
    public void attack(Creep creep) {
        creep.attacked(this.getDamage());
    }

    @Override
    public Golem summon() {
        Golem summonGolem = new Golem(this);
        this.numOfSummon += 1;
        return summonGolem;
    }
}

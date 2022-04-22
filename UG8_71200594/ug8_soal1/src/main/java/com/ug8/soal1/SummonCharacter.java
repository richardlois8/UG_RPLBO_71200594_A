package com.ug8.soal1;

public abstract class SummonCharacter extends Hero{
    protected Summoner owner;

    public SummonCharacter(String name, int health, int damage, Summoner owner) {
        super(name, health, damage);
        this.owner = owner;
    }
}

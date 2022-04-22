package com.ug8.soal1;

public class SpiritBear extends SummonCharacter{
    public SpiritBear(LoneDruid loneDruid) {
        super("Spirit Bear",1000,130,loneDruid);
    }

    public void attack(Creep creep){
        creep.attacked(this.getDamage());
    }
}

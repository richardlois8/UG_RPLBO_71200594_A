package com.ug8.soal1;

public class App
{
    public static void main( String[] args )
    {
        Creep creep1 = new Creep("Creep1",200,20);
        Creep creep2 = new Creep("Creep2",200,20);
        Creep creep3 = new Creep("Creep3",200,20);

        LoneDruid loneDruid = new LoneDruid();
        Warlock warlock = new Warlock();

//        Lone Druid dan warlock summon
        SpiritBear summonSpirit = loneDruid.summon();
        Golem summonGolem = warlock.summon();

//        creep attack spirit dan warlock
        creep1.attack(summonSpirit);
        creep1.attack(warlock);

//        Lonedruid attack creep1
        loneDruid.attack(creep1);

//        Spirit attack creep2
        summonSpirit.attack(creep2);

//        Warlock attack creep3
        warlock.attack(creep3);

//        Golem attack creep 1 dan2
        summonGolem.attack(creep1);
        summonGolem.attack(creep2);

//        golem summon golem lain
        Golem miniGolem = summonGolem.summon();

//        Tampilkan Info
        loneDruid.showCharacterInfo();
        System.out.println();
        summonSpirit.showCharacterInfo();
        System.out.println();
        miniGolem.showCharacterInfo();
    }
}

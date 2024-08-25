package kg.geeks.game.players;

import java.util.Random;

public class Gambler extends Hero {

    public Gambler(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.GAMBLE_CORE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random r = new Random();
        int dice1 = r.nextInt(3) + 1;
        int dice2 = r.nextInt(3) + 1;

        if (dice1 == dice2) {
            int prod = dice1 * dice2;
            boss.setHealth(boss.getHealth() - prod);
            System.out.println(this.getName() + " got a jackpot with " + prod + " DMG");
        } else {
            int sum = dice1 + dice2;
            Hero hero = heroes[r.nextInt(heroes.length)];
            hero.setHealth(hero.getHealth() - sum);
            System.out.println(this.getName() + " gambled away " + hero.getName() + "' " + sum + " HP");
        }
    }

}

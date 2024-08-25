package kg.geeks.game.players;

import java.util.Random;

public class Hacker extends Hero {

    private boolean nextRound = true;

    public Hacker(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.HACKER);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        nextRound = !nextRound;
        if (nextRound) {
            int stolenHealth = boss.getHealth() * (new Random().nextInt(9) + 1) / 100;
            boss.setHealth(boss.getHealth() - stolenHealth);
            Hero hero = heroes[new Random().nextInt(heroes.length)];
            hero.setHealth(hero.getHealth() + stolenHealth);

            System.out.println(this.getName() + " stole " + stolenHealth + " HP from boss and transferred to " + hero.getName());
        }
    }

}

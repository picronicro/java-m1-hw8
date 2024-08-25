package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss("Vurdalak", 2500, 50);
        Warrior warrior1 = new Warrior("Volt", 290, 10);
        Warrior warrior2 = new Warrior("Darius", 280, 15);
        Magic magic = new Magic("Terran", 270, 20);
        Berserk berserk = new Berserk("Viking", 240, 10);
        Medic doc = new Medic("Enstein", 200, 5, 15);
        Medic assistant = new Medic("Green", 300, 5, 5);

        Hacker hacker = new Hacker("Lamer", 220, 5);
        Gambler gambler = new Gambler("Gacha-fag", 300, 5);
        Spitfire spitfire = new Spitfire("Avenger", 300, 25);

        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant, hacker, gambler, spitfire};

        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boolean killedSomeone = boss.attack(heroes);
        System.out.println();

        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && hero.getAbility() != boss.getDefence()) {
                if (hero instanceof Spitfire && killedSomeone) {
                    ((Spitfire) hero).setRage();
                }

                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ---------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}

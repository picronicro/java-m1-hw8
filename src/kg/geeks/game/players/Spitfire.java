package kg.geeks.game.players;

public class Spitfire extends Hero {

    private boolean onRage = false;

    public Spitfire(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.RAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (onRage) {
            boss.setHealth(boss.getHealth() - 80);
            System.out.println(this.getName() + " took revenge on boss for friends with 80 DMG");
            onRage = false;
        }
    }

    public void setRage() {
        onRage = true;
    }

}

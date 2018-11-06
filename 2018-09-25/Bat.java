
public class Bat extends Monster {
    private int flyAwayRate;

    public Bat() {
        super("Bat", 10, 3);
        this.flyAwayRate = 50;
    }

    @Override
    public void defend(Monster m, int dmg) {
        if (r.nextInt(100) < flyAwayRate) {
            System.out.println(getName() + " flew away and received no damage!");
            return;
        } else {
            super.defend(m, dmg);
        }
    }

}

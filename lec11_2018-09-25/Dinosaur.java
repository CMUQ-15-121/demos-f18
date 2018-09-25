
public class Dinosaur extends Monster {
    private int roarFrequency = 50;
    
    public Dinosaur() {
        super("Rex", 30, 12);
    }
    
    public void attack(Monster m) {
        if (r.nextInt(100) < roarFrequency) {
            System.out.println(getName() + " ROARS, tripling the damage!");
            int dmg = r.nextInt(this.getAttack()) * 3;
            super.attack(m, dmg);
        }
        else {
            super.attack(m);
        }
    }

}

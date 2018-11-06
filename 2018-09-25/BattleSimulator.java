public class BattleSimulator {

    public BattleSimulator(Monster a, Monster b) {
        int count = 1;
        while (true) {
            System.out.println("-----Round "+ (count++) +"-----");
            System.out.println(a.getName() + " has " + a.getHp() + " HP remaining");
            System.out.println(b.getName() + " has " + b.getHp() + " HP remaining");

            // a attacks b
            a.attack(b);

            // Check for death
            if (a.isDead() || b.isDead()) {
                break;
            }

            // Swap who is attacking who
            Monster tmp = a;
            a = b;
            b = tmp;
        }

        if (a.isDead() && b.isDead()) {
            System.out.println(a.getName() + " and " + b.getName() + " killed each other!");
        } else if (a.isDead()) {
            System.out.println(b.getName() + " killed " + a.getName() + " and is the winner!");
        } else if (b.isDead()) {
            System.out.println(a.getName() + " killed " + b.getName() + " and is the winner!");
        }
    }

    public static void main(String args[]) {
        Bat b = new Bat();
        Dinosaur d = new Dinosaur();
        BattleSimulator bs = new BattleSimulator(b, d);
    }
}

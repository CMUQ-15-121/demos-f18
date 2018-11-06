import java.util.Random;

public class Monster {
    private String name;
    private int hp;
    private int attack;
    protected Random r;

    public Monster(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.r = new Random();
    }

    public void attack(Monster m, int dmg) {
        System.out.println(this.name + " attacks " + m.getName() + " for " + dmg + " damage");
        m.defend(this, dmg);        
    }
    
    public void attack(Monster m) {
        int dmg = r.nextInt(this.attack)+1;
        attack(m, dmg);
    }

    public void defend(Monster m, int dmg) {
        this.hp -= dmg;
    }

    public boolean isDead() {
        return (this.hp <= 0);
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

}

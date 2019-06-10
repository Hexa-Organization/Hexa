package doupedraku;

public abstract class LivingThings 
{
    public static int move = 50;
    public String name;
    public int maxHealthPoints;
    public int healthPoints;
    public int maxMagicPoints;
    public int magicPoints;
    public int attack;
    public int armor;
    public Weapon weapon;
    
    public boolean CheckForDeath()
    {
        if (this.healthPoints <= 0)
        {
            System.out.println(this.name + " has died");
            return true;
        }
        return false;
    }  
    
    public void Attack(LivingThings enemy)
    {
        int damage = this.attack - enemy.armor;
        if (damage <= 0)
            damage = 1;
        enemy.healthPoints -= damage;
    }
    
}

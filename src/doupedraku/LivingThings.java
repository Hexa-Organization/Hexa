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
    
    public void CheckForDeath()
    {
        if (this.healthPoints <= 0)
            System.out.println(this.name + " has died");
    }  
    
    public void Attack(LivingThings enemy)
    {
        enemy.healthPoints -= this.attack - enemy.armor;
    }
    
}

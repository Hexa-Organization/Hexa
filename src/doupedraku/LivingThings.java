package doupedraku;

public abstract class LivingThings 
{
    public static int move = 50;
    public String name;
    public int maxHealthPoints;
    public int healthPoints;
    public int maxMagicPoints;
    public int magicPoints;
    public int strengthPoints;
    public int defensePoints;
    public Weapon weapon;
    
    
    public void CheckForDeath()
    {
        if (this.healthPoints <= 0)
            System.out.println(this.name + " has died");
    }  
}

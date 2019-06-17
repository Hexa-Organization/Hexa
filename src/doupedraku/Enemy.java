package doupedraku;

public class Enemy extends LivingThings 
{
    public boolean died;
    
    public void AddStats(String name, int maxhp, int att, int arm)
    {
        this.name = name;
        this.maxHealthPoints = maxhp;
        this.healthPoints = maxHealthPoints;
        this.attack = att;
        this.armor = arm;
    }
}

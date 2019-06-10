package doupedraku;

public class Enemy extends LivingThings 
{
    public void AddStats(String name)
    {
        this.name = name;
        this.maxHealthPoints = 25;
        this.healthPoints = maxHealthPoints;
        this.attack = 3;
        this.armor = 1;
    }
}

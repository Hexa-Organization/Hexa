package doupedraku;

public class Player extends LivingThings
{
    public int level;
    public int characterPoints;
    public int maxExpirience;
    public int expirience;
    public boolean isMale;
    public int strength;
    public int inteligence;
    public int stamina;
    public int vitality;
    
    public void LevelUp()
    {
        if (expirience >= maxExpirience)
        {
            expirience = 0;
            level++;
        }
    }
        
    public int GetHealth(int value)
    {
        value = value*10 + 12; 
        return value;
    }
    public int GetAttack(int value)
    {
        value = value/2 - 2;
        if (value <= 0)
            value = 1;
        return value;
    }
    
    public int GetExpirience()
    {
        int value = 36 + level*6;
        return value;
    }
    
    public int GetCharacterPoints()
    {
        int value = 30 + level*10;
        return value;
    }
}

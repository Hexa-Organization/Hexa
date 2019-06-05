package doupedraku;

public class Player extends LivingThings
{
    public static int characterPoints = 40;
    public int level = 1;
    public int maxExpirience = 36+level*6;
    public int expirience = 0;
    public boolean isMale;
    public int strength;
    public int inteligence;
    public int stamina;
    public int vitality;
    
    public int GetHealth(int value)
    {
        value +=3;
        value = value/2;
        value +=1;
        return value;
    }
}

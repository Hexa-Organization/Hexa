package doupedraku;

public class Player extends LivingThings
{
    public int level = 0;
    public int maxExpirience;
    public int expirience;
    
    public int GetHealth(int value)
    {
        value +=3;
        value = value/2;
        value +=1;
        return value;
    }
}

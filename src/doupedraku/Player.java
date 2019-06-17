package doupedraku;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

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
    
    public String[] LoadInfo() throws IOException
    {
        String list[] = new String[9];
        Path path = Paths.get("Character.txt");
        Scanner scanner = new Scanner(path);
        System.out.println("Read text file using Scanner");
        int n = 0;
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();    
            list[n] = line;
            System.out.println(list[n]);
            n++;
        }
        scanner.close();
        return list;
    }
    
    public void SaveInfo(int level, String name, int strength, int stamina, int inteligence, int vitality)
    {
        try (PrintWriter out = new PrintWriter("Character.txt")) 
        {
            out.println(level);
            out.println(name);
            out.println(strength);
            out.println(stamina);
            out.println(inteligence);
            out.println(vitality);
            out.println("0"); 
            out.println("0"); 
            out.println("0"); 
        }
        catch(Exception e)
        {

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

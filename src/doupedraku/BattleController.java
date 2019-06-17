package doupedraku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class BattleController implements Initializable 
{   
    @FXML
    public  Label Pname;
    @FXML
    public  Label Pattack;
    @FXML
    public  Label PhealthPoints;
    @FXML
    public  Label Parmor;
    @FXML
    public Label Janek;
    
    Player player = new Player();

    Enemy janek = new Enemy();
    
    @FXML
    private void Load() throws IOException
    {
        String list[] = player.LoadInfo();
        player.attack = player.GetAttack(GetNumber(list[2]));
        player.armor = player.GetAttack(GetNumber(list[5]));
        player.healthPoints = player.GetHealth(GetNumber(list[3]));
        Pname.setText(list[1]);
        Pattack.setText(player.attack + "");
        PhealthPoints.setText(player.healthPoints + "");
        Parmor.setText(player.armor + "");

        
    }
    
    private int GetNumber(String string)
    {
        String sValue = string;
        sValue = sValue.replaceAll("\\D+", "");
        int number = Integer.parseInt(sValue);
        return number;
    }
    
    @FXML
    public void CreateEnemy()
    {       
        janek.AddStats("Janek");
        Janek.setText(janek.name + janek.healthPoints);
    }
    
    @FXML
    public void Kill()
    {
        player.Attack(janek);
        janek.CheckingForDeath(janek);
        Janek.setText(janek.name + janek.healthPoints);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        try 
        {
            Load();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(BattleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        CreateEnemy();
    }    
    
}

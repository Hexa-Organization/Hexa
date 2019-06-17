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
        Pname.setText(list[1]);
        
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

package doupedraku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class BattleController implements Initializable 
{
    Player player = new Player();
    
    @FXML
    public  Label label;
    @FXML
    public Label Janek;
    
    public void SetName(String text, Player rac)
    {
        label.setText(text);
        player = rac;
    }

    Enemy janek = new Enemy();
    
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
        CreateEnemy();
    }    
    
}

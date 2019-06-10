package doupedraku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class BattleController implements Initializable 
{

    @FXML
    public  Label label;
    @FXML
    public Label Janek;
    
    public void SetName(String text)
    {
        label.setText(text);
    }
    
    
    @FXML
    public void CreateEnemy()
    {
        Enemy janek = new Enemy();
        janek.AddStats("Janek");
        Janek.setText(janek.name);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        CreateEnemy();
    }    
    
}

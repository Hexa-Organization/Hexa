package doupedraku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class TestController implements Initializable
{
    @FXML
    private Label label;
    
    @FXML
    public void CreatePlayer()
    {
        Player player = new Player();
        player.maxHealthPoints = player.GetHealth(10);
        label.setText(Integer.toString(player.maxHealthPoints));    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }    
    
}

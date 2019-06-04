package doupedraku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TestController implements Initializable
{
    @FXML
    private Label label;
    
    @FXML
    TextField myTextField;
    
    @FXML
    public void CreatePlayer()
    {
        String number = myTextField.getText();
        number = number.replaceAll("\\D+","");
        int result = Integer.parseInt(number);
        Player player = new Player();
        player.maxHealthPoints = player.GetHealth(result);
        label.setText(Integer.toString(player.maxHealthPoints));    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }    
    
}

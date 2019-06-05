package doupedraku.Scenes.Controllers;

import doupedraku.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class PlayerCreatorController implements Initializable 
{   
    @FXML
    TextField nameField;
    @FXML
    TextField strengthPointsField;
    @FXML
    TextField staminaPointsField;
    @FXML
    TextField vitalityPointsField;
    @FXML
    TextField inteligencePointsField;
    @FXML
    CheckBox isMaleCheck;
    @FXML
    Label warning;
    
    @FXML
    public Player CreatePlayer()
    {
        Player player = new Player();
        player.name = nameField.getText();
        player.inteligence = GetNumber(inteligencePointsField);
        player.strength = GetNumber(strengthPointsField);
        player.stamina = GetNumber(staminaPointsField);
        player.vitality = GetNumber(vitalityPointsField);
        player.isMale = true;
        int count = player.inteligence + player.strength + player.stamina + player.vitality;
        
        if (count > Player.characterPoints)
        {
            inteligencePointsField.clear();
            strengthPointsField.clear();
            staminaPointsField.clear();
            vitalityPointsField.clear();
            warning.setText("You have assigned more points than 40");
            return null;
        }
        if (count < Player.characterPoints)
        {
            inteligencePointsField.clear();
            strengthPointsField.clear();
            staminaPointsField.clear();
            vitalityPointsField.clear();
            warning.setText("You have assigned less points than 40, please, assign all avalible points");
            return null;
        }
        
        System.out.println(player.name + player.inteligence + player.strength + player.stamina + player.vitality + player.isMale);
        
        return player;
    }
    
    private int GetNumber(TextField field)
    {
        String sValue = field.getText();
        sValue = sValue.replaceAll("\\D+", "");
        int number = Integer.parseInt(sValue);
        return number;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }     
}

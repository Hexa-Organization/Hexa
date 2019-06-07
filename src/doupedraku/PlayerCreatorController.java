package doupedraku;

import doupedraku.Player;
import doupedraku.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class PlayerCreatorController implements Initializable 
{   
    @FXML
    AnchorPane rootPane;
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
    
    Player player = new Player();        

    @FXML
    public void CreatePlayer() throws IOException
    {       
   
        player.name = nameField.getText();
        player.inteligence = GetNumber(inteligencePointsField);
        player.strength = GetNumber(strengthPointsField);
        player.stamina = GetNumber(staminaPointsField);
        player.vitality = GetNumber(vitalityPointsField);
        player.isMale = true;
        player.maxHealthPoints = player.GetHealth(player.stamina);
        player.expirience = 0;
        player.maxMagicPoints = player.GetHealth(player.inteligence);
        player.attack = player.GetAttack(player.strength);
        player.armor = player.GetAttack(player.vitality);
               
        int count = player.inteligence + player.strength + player.stamina + player.vitality;
        
        if (count > player.characterPoints)
        {
            warning.setText("You have assigned more points than 40");
            inteligencePointsField.clear();
            strengthPointsField.clear();
            staminaPointsField.clear();
            vitalityPointsField.clear();
            
        }
        if (count < player.characterPoints)
        {
            inteligencePointsField.clear();
            strengthPointsField.clear();
            staminaPointsField.clear();
            vitalityPointsField.clear();
            warning.setText("You have assigned less points than 40, please, assign all avalible points");
        }
        
        System.out.println(player.name + player.inteligence + player.strength + player.stamina + player.vitality + player.isMale + count);

        try (PrintWriter out = new PrintWriter("Character.txt")) 
        {
            out.println(player.level);
            out.println(player.name);
            out.println(player.strength);
            out.println(player.stamina);
            out.println(player.inteligence);
            out.println(player.vitality);
            out.println(player.isMale);
            out.println(player.maxHealthPoints);
            out.println(player.maxMagicPoints);
            out.println(player.maxExpirience);
            out.println(player.expirience);
            out.println(player.attack);
            out.println(player.armor);
            out.println(player.characterPoints);
            
        }
        catch(Exception e)
        {
            
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("PlayerInfo.fxml"));
        rootPane.getChildren().setAll(pane);

//        Parent root = FXMLLoader.load(getClass().getResource("PlayerInfo.fxml"));
//        
//        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();       
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

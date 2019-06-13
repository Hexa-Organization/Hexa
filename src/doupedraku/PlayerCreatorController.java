package doupedraku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.PrintWriter;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class PlayerCreatorController implements Initializable 
{   
    
    /// This is for Bob
    // Boba máme moc rádi
    /* Asi tak moc jako
    minecraft
    */
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
        player.level = 1;
        player.characterPoints = player.GetCharacterPoints();
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
        
        if (count != player.characterPoints)
        {
            warning.setText("Please, assign exactly all avalible points (hint: It's 40)");
            inteligencePointsField.clear();
            strengthPointsField.clear();
            staminaPointsField.clear();
            vitalityPointsField.clear();         
        }
        else
        {
           System.out.println(player.name + player.inteligence + player.strength + player.stamina + player.vitality + player.isMale + count);

            try (PrintWriter out = new PrintWriter("Character.txt")) 
            {
                out.println(player.level);
                out.println(player.name);
                out.println(player.strength);
                out.println(player.stamina);
                out.println(player.inteligence);
                out.println(player.vitality);
                out.println("0");  
                out.println("0");  
                out.println("0");  
            }
            catch(Exception e)
            {

            }
            AnchorPane pane = FXMLLoader.load(getClass().getResource("PlayerInfo.fxml"));
            rootPane.getChildren().setAll(pane); 
        }
        
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

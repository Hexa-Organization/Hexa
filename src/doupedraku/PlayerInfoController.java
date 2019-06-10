package doupedraku;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayerInfoController implements Initializable 
{
    @FXML
    Text levelName;
    @FXML
    Text hitPoints;
    @FXML
    Text magicPoints;
    @FXML
    TextField strength;
    @FXML
    TextField inteligence;
    @FXML
    TextField stamina;
    @FXML
    TextField vitality;
    @FXML
    Text armor;
    @FXML
    Text attack;
    @FXML
    Text weapon;
    @FXML
    Text expirience;
    @FXML
    Text characterPoints;
    
    Player player = new Player();
    
    private void LoadCharacter() throws IOException
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
        
        player.level = GetNumber(list[0]);
        player.stamina = GetNumber(list[3]);
        player.strength = GetNumber(list[2]);
        player.inteligence = GetNumber(list[4]);
        player.vitality = GetNumber(list[5]);
        player.name = list[1];
        player.expirience = GetNumber(list[6]);
        player.maxHealthPoints = player.GetHealth(player.stamina);
        player.healthPoints = player.maxHealthPoints;
        player.maxMagicPoints = player.GetHealth(player.inteligence);
        player.magicPoints = player.maxMagicPoints;
        player.maxExpirience = player.GetExpirience();
        player.attack = player.GetAttack(player.strength);
        player.armor = player.GetAttack(player.vitality);
        player.characterPoints = player.GetCharacterPoints();
        
        levelName.setText(player.name + " lvl. " + GetString(player.level));
        strength.setText(GetString(player.strength));
        stamina.setText(GetString(player.stamina));
        inteligence.setText(GetString(player.inteligence));
        vitality.setText(GetString(player.vitality));
        hitPoints.setText("Health: " + GetString(player.healthPoints) + " / " + GetString(player.maxHealthPoints));
        magicPoints.setText("Magic: " + GetString(player.magicPoints) + " / " + GetString(player.maxMagicPoints));
        expirience.setText("Expirience: " + GetString(player.expirience) + " / " + GetString(player.maxExpirience));
        attack.setText("attack: " + GetString(player.attack));
        armor.setText("armor: " + GetString(player.armor));
        characterPoints.setText("Character Points: " + GetString(player.characterPoints));      
    }
    
    public void Update() throws IOException
    { 
        player.strength = GetNumber(strength.getText());
        player.stamina = GetNumber(stamina.getText());
        player.inteligence = GetNumber(inteligence.getText());
        player.vitality = GetNumber(vitality.getText());
        int count = player.inteligence + player.strength + player.stamina + player.vitality;
        if (count != player.characterPoints)
        {
            System.out.println("I not dont NOOONONONnOnON NON ONwork!");
        }
        else
        {
            try (PrintWriter out = new PrintWriter("Character.txt")) 
            {
                out.println(player.level);
                out.println(player.name);
                out.println(player.strength);
                out.println(player.stamina);
                out.println(player.inteligence);
                out.println(player.vitality);    
                out.println(player.expirience);
            }
            catch(Exception e)
            {

            }  
            LoadCharacter();   
        }    
    }
    
    private void LoadPlayer()
    {
       try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Battle.fxml"));
            Parent root = (Parent) loader.load();

            BattleController secController=loader.getController();
            secController.SetName(player.name + player.attack, player);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
    }
    
    private String GetString(int value)
    {
        String s = String.valueOf(value);
        return s;
    }
    
    private int GetNumber(String string)
    {
        String sValue = string;
        sValue = sValue.replaceAll("\\D+", "");
        int number = Integer.parseInt(sValue);
        return number;
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        try 
        {
            LoadCharacter();
            LoadPlayer();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(PlayerInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}

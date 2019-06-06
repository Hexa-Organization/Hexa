package doupedraku.Scenes.Controllers;

import doupedraku.Player;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
    
    public void LoadCharacter() throws IOException
    {
        String list[] = new String[14];
        Path path = Paths.get("Character.txt");
        Scanner scanner = new Scanner(path);
        System.out.println("Read text file using Scanner");
        int n = 0;
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();    
            System.out.println(line);
            list[n] = line;
            System.out.println(list[n]);
            n++;
        }           
        levelName.setText(list[1] + " lvl." + list[0]);
        strength.setText(list[2]);
        stamina.setText(list[3]);
        inteligence.setText(list[4]);
        vitality.setText(list[5]);
        hitPoints.setText("Hit Points: " + list[7] + " / " + list[7]);
        magicPoints.setText("Magic Points: " + list[8] + " / " + list[8]);
        expirience.setText("Expirience Points: " + list[10] + " / " + list[9]);
        attack.setText("attack: " + list[11]);
        armor.setText("armor: " + list[12]);
        characterPoints.setText("Character Points: " + list[13]);        
        scanner.close();
    }
    
    public void Update()
    {
        strength.getText();
        stamina.getText();
        inteligence.getText();
        vitality.getText();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }    
    
}

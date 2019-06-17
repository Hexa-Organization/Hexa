package doupedraku;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
    public Label Ename;
    @FXML
    public Label Eattack;
    @FXML
    public Label EhealthPoints;
    @FXML
    public Label Earmor;
    
    
    Player player = new Player();

    Enemy enemy = new Enemy();
    
    //
    public void OpenAlert()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WinAlert.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();        
        }
        
        catch(Exception e)
        {
            System.out.println("Nefunguje to!!");
        }
    }
    
  
    
    @FXML
    private void Load() throws IOException
    {
        String list[] = player.LoadInfo();
        player.attack = player.GetAttack(GetNumber(list[2]));
        player.armor = player.GetAttack(GetNumber(list[5]));
        player.healthPoints = player.GetHealth(GetNumber(list[3]));
        player.name = list[1];
           
    }
    
    private int GetNumber(String string)
    {
        String sValue = string;
        sValue = sValue.replaceAll("\\D+", "");
        int number = Integer.parseInt(sValue);
        return number;
    }
    
    public void UpdateInfo()
    {
        Ename.setText(enemy.name);
        Eattack.setText("attack: " + enemy.attack);
        EhealthPoints.setText("HP: " + enemy.healthPoints);
        Earmor.setText("armor: " + enemy.armor);
        Pname.setText(player.name);
        Pattack.setText("attack: " + player.attack);
        PhealthPoints.setText("HP: " + player.healthPoints);
        Parmor.setText("armor: " + player.armor);  
    }
    
    @FXML
    public void CreateEnemy()
    {       
        Enemy Janek = new Enemy();
        Enemy Bobik = new Enemy();
        Enemy JohnMeka = new Enemy();
        Enemy Blackie = new Enemy();
        
        Janek.AddStats("Janek", 42, 4, -2);
        Bobik.AddStats("Bobik", 1500, 1, -35);
        JohnMeka.AddStats("John Meka", 96, 7, 2);
        Blackie.AddStats("Blackie", 2000, 200, 200);
        
        Enemy enemis[] = new Enemy[4];
        enemis[0] = Janek;
        enemis[1] = Bobik;
        enemis[2] = JohnMeka;
        enemis[3] = Blackie;
        
        Random rand = new Random();

        int random = rand.nextInt(4);

        enemy = enemis[random];
    }
    
    @FXML
    public void Kill()
    {
        player.Attack(enemy);
        enemy.Attack(player);
        UpdateInfo();
        if(enemy.CheckForDeath())
        {
            Stage stage = (Stage) Pname.getScene().getWindow();
            stage.close();
            OpenAlert();
        }
        
        if(player.CheckForDeath())
        {
                ////TADY TO DODEJ SEFE
        }
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
        UpdateInfo();
    }    
    
}

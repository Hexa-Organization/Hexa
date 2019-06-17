package doupedraku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuController implements Initializable {
    
    @FXML
    public Button start;
    @FXML
    public Button exit;
    @FXML
    public ImageView MenuBackround;
    
    
    @FXML
    public void StartMethod()
    {
           try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PlayerCreator.fxml"));
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
    public void ExitMethod()
    {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void ButtonActionStart()
    {
        System.out.println("Hraješ");
        StartMethod();
        ExitMethod();
    }
    
     @FXML
    public void ButtonActionExit()
    {
        System.out.println("Nashledanou!");
        ExitMethod();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    

 
}

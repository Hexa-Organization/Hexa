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

public class AlertController implements Initializable 
{   
    @FXML
    public Button confirm;
    @FXML
    public Button reject;
    @FXML
    public ImageView alertbackround;
    @FXML
    public ImageView logo;
    
    @FXML
    public void Exit()
    {
        Stage stage = (Stage) reject.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void ConfirmF()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Battle.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            Exit();
        }
        
        catch(Exception e)
        {
            System.out.println("Nefunguje to!!");
        }
    }
    
    @FXML
    public void RejectF()
    {
         Exit();
    }
     
    
    @FXML
    public void ConfirmFight()
    {
        System.out.println("Bojuješ");
        ConfirmF();
       
    }
    
    @FXML
    public void RejectFight()
    {
        System.out.println("NeBojuješ");
        RejectF();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }    
    
}

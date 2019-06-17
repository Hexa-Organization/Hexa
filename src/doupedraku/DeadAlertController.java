package doupedraku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeadAlertController implements Initializable 
{
    @FXML
    public Button cnt;
    
    @FXML
    public void Exit()
    {
         Stage stage = (Stage) cnt.getScene().getWindow();
         stage.close();
    }
    
    @FXML
    public void Continue()
    {
        System.out.println("Čauuuuu kokosko");
        Exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }    
    
}

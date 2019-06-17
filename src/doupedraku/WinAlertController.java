package doupedraku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WinAlertController implements Initializable
{

    @FXML
    public Button cnf;
    
     @FXML
    public void Exit()
    {
        Stage stage = (Stage) cnf.getScene().getWindow();
        stage.close();
    }
    
    public void CnfAction()
    {
        System.out.println("ahohojjo");
        Exit();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doupedraku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Student
 */
public class WinAlertController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * FXML Controller class
 *
 * @author bohou
 */
public class AlertController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public Button confirm;
    @FXML
    public Button reject;
    @FXML
    public ImageView alertbackround;
    @FXML
    public ImageView logo;
    
    
    
    //methodyy
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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

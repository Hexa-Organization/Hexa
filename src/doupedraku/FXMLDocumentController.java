package doupedraku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLDocumentController implements Initializable 
{
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction() throws IOException
    {
        System.out.println("Dante!");
        label.setText("Smrdis!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }    
    
}

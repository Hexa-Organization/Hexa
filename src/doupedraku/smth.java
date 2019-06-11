package doupedraku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author bohou
 */
public class smth implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private AnchorPane pane;
    @FXML
    private GridPane grid;
    @FXML
    private ImageView chr;
    @FXML
    public ImageView tree;
    
    public int x = 0;
    int y = 0;

    public void Generate()
    {
        grid.setConstraints(tree, x=4, y=1);
    }
    
    
    @FXML
    private void handleButtonAction(KeyEvent event) 
    {
        System.out.println("Dopředu");
        if (x == 4 && y ==1 || x == 2 && y ==3)
        {
     //       System.out.println("strom");
     //       grid.setConstraints(sd, --x, y);
        }
        else
        {
            Movement(event);
        }

    }
    
    private void Movement(KeyEvent event)
    {
        if(event.getCode() == KeyCode.D)
        {
            System.out.println("Dopředu");
            grid.setConstraints(chr, ++x, y);
            
            if (x == 4 && y ==1 || x == 2 && y ==3)
            {
                System.out.println("strom");
                grid.setConstraints(chr, --x, y);
            }
        }
        
        else if(event.getCode() == KeyCode.A)
        {
            System.out.println("Dozadu");
            grid.setConstraints(chr, --x, y);
            if (x == 4 && y ==1 || x == 2 && y ==3)
            {
                System.out.println("strom");
                grid.setConstraints(chr, ++x, y);
            }
        }
        
        else if(event.getCode() == KeyCode.W)
        {
            System.out.println("DoLeva");
            GridPane.setConstraints(chr, x, --y);
            if (x == 4 && y ==1 || x == 2 && y ==3)
            {
                System.out.println("strom");
                grid.setConstraints(chr, x, ++y);
            }
        }
        
        else if(event.getCode() == KeyCode.S)
        {
            System.out.println("DoPrava");
            grid.setConstraints(chr, x, ++y);
            if (x == 4 && y ==1 || x == 2 && y ==3)
            {
                System.out.println("strom");
                grid.setConstraints(chr, x, --y);
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        grid.addRow(1);
       
    }    
    
}
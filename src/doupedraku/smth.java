package doupedraku;

import javafx.application.Application;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

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
    @FXML
    public ImageView Grass;
    @FXML
    public AnchorPane rootPane;
    
    public int x = 0;
    int y = 0;

    public void Generate()
    {
        grid.setConstraints(tree, x=4, y=1);
    }
    
    public static void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Alert.class.getResource("/Alert.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void handleButtonAction(KeyEvent event) throws IOException 
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
    
    private void Movement(KeyEvent event) throws IOException
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
        
         if(x == 4 && y == 4)
            {
            System.out.println("Bacha Arénaaa");
            
            
            }
    
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        grid.addRow(1);
       
    }    

    private InputStream Alert(String aletfxml) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
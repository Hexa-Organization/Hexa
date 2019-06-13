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
public class MapController implements Initializable 
{
    @FXML
    private Label label;
    @FXML
    private AnchorPane pane;
    @FXML
    private GridPane grid;
    @FXML
    private ImageView chr;
    int x = 0;
    int y = 0;
    @FXML
    public ImageView tree0;
    int tree0x = 1;
    int tree0y = 2;
    @FXML
    public ImageView tree1;
    int tree1x = 5;
    int tree1y = 5;
    @FXML
    public ImageView tree2;
    int tree2x = 9;
    int tree2y = 1;
    @FXML
    public ImageView tree3;
    int tree3x = 0;
    int tree3y = 8;
    @FXML
    public ImageView tree4;
    int tree4x = 6;
    int tree4y = 4;
    
    int fieldx[] = new int[5];
    int fieldy[] = new int[5];
    
    public void Generate()
    {
        grid.setConstraints(tree0, tree0x, tree0y);
        fieldx[0] = tree0x;
        fieldy[0] = tree0y;
        grid.setConstraints(tree1, tree1x, tree1y);
        fieldx[1] = tree1x;
        fieldy[1] = tree1y;
        grid.setConstraints(tree2, tree2x, tree2y);
        fieldx[2] = tree2x;
        fieldy[2] = tree2y;
        grid.setConstraints(tree3, tree3x, tree3y);
        fieldx[3] = tree3x;
        fieldy[3] = tree3y;
        grid.setConstraints(tree4, tree4x, tree4y);
        fieldx[4] = tree4x;
        fieldy[4] = tree4y;    
    }
    
    @FXML
    private void handleButtonAction(KeyEvent event) 
    {
        fieldx[0] = tree0x;
        fieldy[0] = tree0y;
        
        fieldx[1] = tree1x;
        fieldy[1] = tree1y;
        
        fieldx[2] = tree2x;
        fieldy[2] = tree2y;
        
        fieldx[3] = tree3x;
        fieldy[3] = tree3y;
        
        fieldx[4] = tree4x;
        fieldy[4] = tree4y;
        
        Movement(event);
        
//        for (int i = 0; i < fieldx.length; i++)
//        {
//            if(x == fieldx[i] && y ==fieldx[i])
//            {
//                System.out.println("NO");
//                grid.setConstraints(chr, --x, y);
//                break;
//            }
//            else
//            {
//                Movement2(event);
//                break;
//            }
//        }
    }
    

    
    private void Movement2(KeyEvent event)
    {
        if(event.getCode() == KeyCode.D)
        {      
            System.out.println("Dopředu");
            grid.setConstraints(chr, ++x, y);
        }
        
        else if(event.getCode() == KeyCode.A)
        {
            System.out.println("Dozadu");
            grid.setConstraints(chr, --x, y);
        }
        
        else if(event.getCode() == KeyCode.W)
        {
            System.out.println("DoLeva");
            GridPane.setConstraints(chr, x, --y);
        }
        
        else if(event.getCode() == KeyCode.S)
        {
            System.out.println("DoPrava");
            grid.setConstraints(chr, x, ++y);
        }
    }
    
    
    
    
    
    
    private void Movement(KeyEvent event)
    {
        fieldx[0] = tree0x;
        fieldy[0] = tree0y;
        
        fieldx[1] = tree1x;
        fieldy[1] = tree1y;
        
        fieldx[2] = tree2x;
        fieldy[2] = tree2y;
        
        fieldx[3] = tree3x;
        fieldy[3] = tree3y;
        
        fieldx[4] = tree4x;
        fieldy[4] = tree4y;
        
        if(event.getCode() == KeyCode.D)
        {
            for (int i = 0; i < fieldx.length; i++)
            {
                if (x == fieldx[i] && y == fieldy[i])
                {
                    System.out.println("NO");
                }
                break;
            }
            System.out.println("Dopředu");
            grid.setConstraints(chr, ++x, y);

                
                
                
//                
//                if (x != fieldx[i] && y != fieldy[i])
//                {
//                    System.out.println("Dopředu");
//                    grid.setConstraints(chr, ++x, y);
//                } 
//                else if (x == fieldx[i] && y == fieldy[i])
//                {
//                    System.out.println("strom");
//                    grid.setConstraints(chr, --x, y);
//                    break;
//                }
            
        }
        
        
//        if(event.getCode() == KeyCode.D)
//        {
//            System.out.println("Dopředu");
//            grid.setConstraints(chr, ++x, y);
//            
//            if (x == fieldx[i] && y == fieldy[i])
//            {
//                System.out.println("strom");
//                grid.setConstraints(chr, --x, y);
//            }
//        }
        
        if(event.getCode() == KeyCode.A)
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
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        
        grid.addRow(1);
        Generate();
       
    }    
    
}
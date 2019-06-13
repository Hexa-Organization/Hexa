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
        Movement(event);
    }
    
    @FXML
    public void Movement(KeyEvent event)
    {
        
        
        switch (event.getCode())
        {
            case D:
                if(x == 9)
                    break;
                System.out.println("Doprava");
                grid.setConstraints(chr, ++x, y);

                if (TreePosition())
                {
                    System.out.println("NO");
                    grid.setConstraints(chr, --x, y);
                }
                
                break;

            case A:
                if(x == 0)
                    break;
                System.out.println("Doleva");
                grid.setConstraints(chr, --x, y); 

                if (TreePosition())
                {
                    System.out.println("NO");
                    grid.setConstraints(chr, ++x, y);
                }
                break;

            case S:
                if(y == 9)
                    break;
                System.out.println("Dolu");
                grid.setConstraints(chr, x, ++y);

                if (TreePosition())
                {
                    System.out.println("NO");
                    grid.setConstraints(chr, x, --y);
                }
                break;

            case W:
                if(y == 0)
                    break;
                System.out.println("Nahoru");
                grid.setConstraints(chr, x, --y);

                if (TreePosition())
                {
                    System.out.println("NO");
                    grid.setConstraints(chr, x, ++y);
                }
                break;
        }       
    }
    
    private boolean TreePosition()
    {
        for (int i = 0; i < fieldx.length; i++)
        {
            if (x == fieldx[i] && y == fieldy[i])
            {
                return true;
            }     
        }
        return false;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       // grid.addRow(1);
        Generate();  
    }       
}
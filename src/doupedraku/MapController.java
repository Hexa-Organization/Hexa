package doupedraku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MapController implements Initializable 
{
    @FXML
    public ImageView grs;
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
    int tree4x = 8;
    int tree4y = 4;
    
    //enemy
    
    @FXML
    public ImageView enemy1;
    int enemy1x = 2;
    int enemy1y = 5;
    @FXML
    public ImageView enemy2;
    int enemy2x = 9;
    int enemy2y = 7;
    @FXML
    public ImageView enemy3;
    int enemy3x = 1;
    int enemy3y = 3;
    @FXML
    public ImageView enemy4;
    int enemy4x = 5;
    int enemy4y = 4;
    
    int fieldx[] = new int[5];
    int fieldy[] = new int[5];
    ImageView trees[] = new ImageView[5];
    
    int field2x[] = new int[4];
    int field2y[] = new int[4];
    ImageView enemys[] = new ImageView[4];
    
    private void Generate()
    {
        trees[0] = tree0;
        trees[1] = tree1;
        trees[2] = tree2;
        trees[3] = tree3;
        trees[4] = tree4;
        
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
        
        enemys[0] = enemy1;
        enemys[1] = enemy2;
        enemys[2] = enemy3;
        enemys[3] = enemy4;
        
        field2x[0] = enemy1x;
        field2y[0] = enemy1y;
        field2x[1] = enemy2x;
        field2y[1] = enemy2y;
        field2x[2] = enemy3x;
        field2y[2] = enemy3y;
        field2x[3] = enemy4x;
        field2y[3] = enemy4y;
        
        for (int i = 0; i < trees.length; i++)
        {
            grid.setConstraints(trees[i], fieldx[i], fieldy[i]);
        }
        
        for (int i = 0; i < enemys.length; i++)
        {
            grid.setConstraints(enemys[i], field2x[i], field2y[i]);
        }
    }
    
    @FXML
    private void handleButtonAction(KeyEvent event) 
    {
        Movement(event);
    }
    
   
     @FXML
    public void Fighting()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();        
        }
        
        catch(Exception e)
        {
            System.out.println("Nefunguje to!!");
        }
        grid.setConstraints(chr, --x, y);
    }
    
    @FXML
    private void Movement(KeyEvent event)
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
                
                else if(EnemyPosition())
                {
                    System.out.println("Fight");
                    Fighting();
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
                
                 else if(EnemyPosition())
                {
                    System.out.println("Fight");
                    Fighting();
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
                
                 else if(EnemyPosition())
                {
                    System.out.println("Fight");
                    Fighting();
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
                
                   else if(EnemyPosition())
                {
                    System.out.println("Fight");
                    Fighting();
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
    
    private boolean EnemyPosition()
    {
        for (int i = 0; i < field2x.length; i++)
        {
            if (x == field2x[i] && y == field2y[i])
            {
                return true;
            }     
        }
        return false;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Generate();  
    }       
}
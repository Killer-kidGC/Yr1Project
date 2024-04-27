import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;

public class Grid{
    //Grid attributes:
    String blank;
    String blackShade;

    //Constructor for the 'Grid' class.
    public Grid() {

        blank = "blank.jpg";
        blackShade = "black.jpg";

    }

    //Getter method for the file name of the image for the blank tile.
    public String getBlank() {

        return blank;

    }

    //Getter method for the file name of the image for the black tile.
    public String getBlack() {

        return blackShade;

    }

    //This function draws and displays the grid on screen when called.
    public JFrame drawGrid(){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Sets dimensions, row/column count and square spacing.
        frame.setSize(900,1000);
        frame.setLayout(new GridLayout(15,15,10,10));
        
        //Grid represented as a 2D array of interactive buttons.
        JButton[][] tiles = new JButton[15][15];
    
        ImageIcon blankTile = new ImageIcon(getBlank());
    
        //A nested for loop within a for loop to create buttons for each square in each dimension of the array.
        //The first loop being for the first dimension.
        for (int i = 0; i < 15; i++ ){

            //The nested loop being for the second dimension.
            for (int j = 0; j < 15; j++){
                
                tiles[i][j] = new JButton(blankTile);
                frame.add(tiles[i][j]);
            }
        }
    
        frame.setVisible(true);

        return frame;



    }



}

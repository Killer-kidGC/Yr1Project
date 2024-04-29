//Libraries for this class.
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class Grid implements ActionListener{
    //Grid attributes:
    JButton[][] tiles;
    JFrame gridframe;
    int buttonXAxis;
    int buttonYAxis;


    
    //Constructor for the 'Grid' class.
    public Grid() {
        tiles = new JButton[15][15];
        gridframe = new JFrame();
        gridframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Sets dimensions, row/column count and square spacing.
        gridframe.setSize(900,1000);
        gridframe.setLayout(new GridLayout(15,15,10,10));
        
        //Grid represented as a 2D array of interactive buttons.
        JButton[][] grid = getTileArray();

    
        //A nested for loop within a for loop to create buttons for each square in each dimension of the array.
        //The first loop being for the first dimension.
        for (int i = 0; i < grid.length; i++ ){

            //The nested loop being for the second dimension.
            for (int j = 0; j < grid[0].length; j++){
                
                grid[i][j] = new JButton();
                grid[i][j].setBackground(Color.GRAY);
                gridframe.add(grid[i][j]);
                grid[i][j].addActionListener(this);
                
            }
        }

        gridframe.setVisible(true);

    }





    //Getter for returning the attribute 'gridframe' which is where the value for the playing grid is stored.
    public JFrame getGridFrame() {

        return gridframe;
    }


    //Getter method for returning the array of interactive tiles.
    public JButton[][] getTileArray(){

        return tiles;
    }
    

    //Sets the value of the attribute 'buttonXAxis' to the current clicked button.
    public void setXAxis(int x){

        this.buttonXAxis = x;

    }


    //Sets the value of the attribute 'buttonYAxis' to the current clicked button.
    public void setYAxis(int y){

        buttonYAxis = y;

    }


    //gets the x-coordinate of clicked button.
    public int getXAxis(){

        return buttonXAxis;

    }


    //Gets the y-coordinate of clicked button.
    public int getYAxis(){

        return buttonYAxis;

    }




    //Finds and outputs the position of the button/ tile that has been clicked.
    public void actionPerformed(ActionEvent e) {
        JButton[][] buttons = getTileArray();

        for (int i = 0; i < buttons.length; i++) {

            for (int j = 0; j < buttons[0].length; j++) {

                if (e.getSource() == buttons[i][j]){
                    
                    System.out.println("Button cicked at: (" + i + ", "+ j +")");

                    setXAxis(i);
                    setYAxis(j);
                    changeColour();

                }

             }

        }
 
    }




    //Changes colour of button to black when clicked.
    public void changeColour(){

        int x = getXAxis();
        int y = getYAxis();

        tiles[x][y].setBackground(Color.BLACK);

    }

}

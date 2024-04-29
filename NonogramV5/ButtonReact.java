import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class ButtonReact implements ActionListener {

    Grid grid;

    public ButtonReact(){

        grid = new Grid();

        for (int i = 0; i < grid.tiles.length; i++){

            for (int j = 0; j < grid.tiles[0].length; j++){

                grid.tiles[i][j].addActionListener(this);
            }
        }
    }








    //Finds and outputs the position of the button/ tile that has been clicked.
    public void actionPerformed(ActionEvent e) {
        JButton[][] buttons = grid.getTileArray();

        for (int i = 0; i < buttons.length; i++) {

            for (int j = 0; j < buttons[0].length; j++) {

                if (e.getSource() == buttons[i][j]){

                    grid.setXAxis(i);
                    grid.setYAxis(j);
                    changeColour();
                    //counter incrememented on each click.
                    grid.clickCount[i][j]++;

                    System.out.println("Button cicked at: (" + i + ", "+ j +", "+ grid.clickCount[i][j] +")");

                }

             }

        }
 
    }




    //Changes colour of button to black when clicked.
    public void changeColour(){

        int x = grid.getXAxis();
        int y = grid.getYAxis();

        if (grid.clickCount[x][y] == 0){

            grid.tiles[x][y].setBackground(Color.BLACK);


        }

        else if(grid.clickCount[x][y] == 1 ){

            grid.tiles[x][y].setBackground(Color.WHITE);

        
        }

        else{

            grid.clickCount[x][y] = -1;
            grid.tiles[x][y].setBackground(Color.GRAY);

        }


    }
    
}

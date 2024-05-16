//Libraries:
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;


public class ButtonReact extends JFrame implements ActionListener {
    //Attributes:
    Grid grid;
    int[][] filledArray;
    int[][] solution;
    boolean clicked;
    Popup endScreen;

    //Constructor.
    public ButtonReact(int answer[][]){

        //Creates an instance of the 'Grid' class.
        grid = new Grid();
        filledArray = new int[15][15];
        solution = answer;

        
        


        //Adds an action listener to each button in the 2D array so that the program knows when a button is clicked.
        for (int i = 0; i < grid.tiles.length; i++){


            for (int j = 0; j < grid.tiles[0].length; j++){

                filledArray[i][j] = -1;

                grid.tiles[i][j].addActionListener(this);
            }
        }

        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                System.out.printf("%d ", solution[i][j]);
            }
            System.out.println();
        }
    }

    //gets the array showing where each colour has been filled in.
    public int[][] getFilledArray(){
        int x = 0;
        int y = 1;
        System.out.println(filledArray[x][y]);
        return filledArray;
    }

    public int[][] getSolution(){
        return solution;
    }





    //Finds and outputs the position of the button/ tile that has been clicked.
    public void actionPerformed(ActionEvent e) {
        JButton[][] buttons = grid.getTileArray();

        for (int i = 0; i < buttons.length; i++) {

            for (int j = 0; j < buttons[0].length; j++) {
                //Finds what button was clicked.
                if (e.getSource() == buttons[i][j]){

                    grid.setXAxis(i);
                    grid.setYAxis(j);
                    
                    //counter incrememented on each click so the program knows what colour to display according to amount of clicks.
                    grid.clickCount[i][j]++;
                    changeColour();

                    //Debug.
                    System.out.println("Button cicked at: (" + i + ", "+ j +", "+ grid.clickCount[i][j] + "  ;; " + grid.clickCount[i][j]+")");
                    if(checkArray()){

                        System.out.println("Correct");
                        popUp();
                    }
                    else{

                        System.out.println("Wrong");
                    }

                }

             }

        }
 
    }




    //Changes colour of button to black when clicked.
    public void changeColour(){

        int x = grid.getXAxis();
        int y = grid.getYAxis();
        //First click turns square black.
        if (grid.clickCount[x][y] == 0){

            grid.tiles[x][y].setBackground(Color.BLACK);
            filledArray[x][y] = 0;
            //debug
            System.out.println("colour: (" + x + ", "+ y +", "+ filledArray[x][y] +")");
            


        }
        //Second click turns square white.
        else if(grid.clickCount[x][y] == 1 ){

            grid.tiles[x][y].setBackground(Color.WHITE);
            filledArray[x][y] = 1;
            //debug
            System.out.println("colour: (" + x + ", "+ y +", "+ filledArray[x][y] +")");
            


        
        }
        //3rd click aka anything above the second click turns square grey again (unshaded).
        else{

            grid.clickCount[x][y] = -1;
            grid.tiles[x][y].setBackground(Color.GRAY);
            filledArray[x][y] = -1;
            //debug
            System.out.println("colour: (" + x + ", "+ y +", "+ filledArray[x][y] +")");
            
        

        }


    }

    //Iterates through and checks each buttons colour value which has been stored in the playerDrawing array to see if it is correct by comparing it to its corresponding answer in the solution array.
    public boolean checkArray(){

        int[][] playerDrawing = getFilledArray();

        for (int i = 0; i < solution.length; i++){

            for (int j = 0; j < solution[0].length; j++){
                //Comparison.
                if (solution[i][j] != playerDrawing[i][j]){
                    System.out.printf("incorrect (%d, %d) expected %d, got %d%n", i, j, solution[i][j], playerDrawing[i][j]);

                    //System.out.println("player" + playerDrawing[i][j]);
                    return false;

                    
                }
            }
        }

        return true;


    }


    //Outputs 'game complete' message.
    public void popUp(){

        JOptionPane.showMessageDialog(this, "Correct - Game complete!", "Well done!", JOptionPane.INFORMATION_MESSAGE);

    }

    
    
}

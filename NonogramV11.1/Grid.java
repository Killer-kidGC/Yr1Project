//Libraries for this class.
import java.awt.*;
import javax.swing.*;

public class Grid{
    //Grid attributes:
    JButton[][] tiles;
    JPanel gridframe;
    int buttonXAxis;
    int buttonYAxis;
    int[][]clickCount;
    int xAxis = 15;
    int yAxis = 15;
    JPanel[] numSide;
    JPanel[] numTop;
    

    //Constructor for the 'Grid' class.
    public Grid() {

        //Border Frame setup:
        //Border layout so numbers can be displayed beside grid.
        JFrame borderframe = new JFrame();
        borderframe.setLayout(new BorderLayout());
        tiles = new JButton[xAxis][yAxis];
        gridframe = new JPanel();
        borderframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Sets dimensions for the external frame.
        borderframe.setSize(900,1000);
        borderframe.setTitle("Nonogram");
        


        //Creates a panel on the left for numbers to be placed beside grid.
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.gray);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 20));



        //Creates a top panel for numbers to be placed beside the grid.
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.gray);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 20));



        //Grid of pixels setup:
        gridframe = new JPanel();
        gridframe.setLayout(new GridLayout(15,15,10,10));
        //Grid represented as a 2D array of interactive buttons.
        JButton[][] grid = getTileArray();
        clickCount = new int[15][15];



        //Number setup:
        //Side panel to hold numbers.
        JPanel numbersSide  = new JPanel();
        numbersSide.setLayout(new GridLayout(0, 1, 10, 10));
        //Top panel to hold numbers.
        JPanel numbersTop = new JPanel();
        numbersTop.setLayout(new GridLayout(1, 0, 10, 10));   
        
        //Arrays to store numbers on each axis.
        numSide = new JPanel[xAxis];
        numTop = new JPanel[yAxis];
        
        //A nested for loop within a for loop to create buttons for each square in each dimension of the array.
        //The first loop being for the first dimension.
        for (int i = 0; i < grid.length; i++ ){
            
            //Creates X and Y axis numbers to be displayed.
            numSide[i] = new JPanel();
            JLabel num = new JLabel();
            numSide[i].add(num);
            numbersSide.add(numSide[i]);

            numTop[i] = new JPanel();
            JLabel numT = new JLabel();
            numTop[i].add(numT);
            numbersTop.add(numTop[i]);

            //The nested loop is to create new JButton instances and add them into the grid.
            for (int j = 0; j < grid[0].length; j++){

                grid[i][j] = new JButton();
                grid[i][j].setBackground(Color.GRAY);
                grid[i][j].setSize(new Dimension(10, 10));
                gridframe.add(grid[i][j]);
                
                //Sets an array to hold the amount of times a button has been clicked for each button.
                clickCount[i][j] = -1;
                
            }


            

        }

        //Elephant numbers (answer clues):
        //side numbers:
        setLabelSide(0, "2 1 1 2");
        setLabelSide(1, "2 4 3 1");
        setLabelSide(2, "10");
        setLabelSide(3, "3 2 2 3");
        setLabelSide(4, "9 3");
        setLabelSide(5, "1 2 6");
        setLabelSide(6, "1 2 2 1 1");
        setLabelSide(7, "3 1 1 2");
        setLabelSide(8, "2 1 6 1");
        setLabelSide(9, "2 2 2 3 1");
        setLabelSide(10, "1 1 1 2 2");
        setLabelSide(11, "2 1 2 4");
        setLabelSide(12, "2 1 2 4");
        setLabelSide(13, "1 1 2 3");
        setLabelSide(14, "4");

        //Top numbers:
        setLabelTop(0, "1 5 1");
        setLabelTop(1, "1 3 3 1 1");
        setLabelTop(2, "5 1 2 1");
        setLabelTop(3, "4 3 2");
        setLabelTop(4, "1 1 6");
        setLabelTop(5, "6");
        setLabelTop(6, "4, 1");
        setLabelTop(7, "2 3 6");
        setLabelTop(8, "6 6");
        setLabelTop(9, "1 4 1");
        setLabelTop(10, "2 1 3 3");
        setLabelTop(11, "1 4, 6");
        setLabelTop(12, "1 3 5");
        setLabelTop(13, "1 2 1 2");
        setLabelTop(14, "2 4");


        //Sets the position and adds each component to the BorderLayout so it is displayed in the window.
        borderframe.add(gridframe, BorderLayout.CENTER);

        borderframe.add(numbersTop, BorderLayout.NORTH);
        
        borderframe.add(numbersSide, BorderLayout.WEST);

        borderframe.setVisible(true);

    }

    //A setter function to reduce the amount of JLabel variables needed to be created for the side panel.

    public JLabel setLabelSide(int position, String values){

        JLabel replaceSide = (JLabel) numSide[position].getComponent(0);
        replaceSide.setText(values);

        return replaceSide;



    }

    
    //A setter function to reduce the amount of JLabel variables needed to be created for the top panel.

    public JLabel setLabelTop(int position, String values){

        JLabel replaceTop = (JLabel) numTop[position].getComponent(0);
        replaceTop.setText(values);

        return replaceTop;



    }




    //Getter for returning the attribute 'gridframe' which is where the value for the playing grid is stored.
    public JPanel getGridFrame() {

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

}

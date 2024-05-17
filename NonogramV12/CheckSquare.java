import java.util.*;
public class CheckSquare{
    ButtonReact buttonR;
    int[][] solution;
    int rangeX;
    int rangeY;
    ReadFile read;

    //Constructor.
    public CheckSquare(){

        read = new ReadFile();
        solution = new int[read.getWidth()][read.getHeight()];
        rangeX = read.getWidth();
        rangeY = read.getHeight();
        setSolution();
        buttonR = new ButtonReact(solution);
        colourCounter();


        

    }

    private void setSolution(){
        // -1 = Grey
        // 0 = Black
        // 1 = White
        solution = read.getAnswer();
    }

    //Getter method for the puzzle solution
    public int[][]getSolution(){

        return this.solution;
    }

    public void colourCounter(){

        //Hash map for storing the numbers of blocks if black in each row.
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> columnMap = new HashMap<>();

        int counter = 0;
        
        //iterate through the array:
        for (int y = 0; y < 15; y++) {
            //Array list for storing the numbers is initialised so it can be stored in the HashMap.
            //Initialised at the start of for loop so total resets.
            List<Integer> total = new ArrayList<>();
        
            //Sets the current index at y and stores the array list dynamically which then resets on each iteration.
            rowMap.put(y, total);
            for (int x = 0; x < 15; x++) {
                //Counter increases until it equals 1.
                if (solution[y][x] == 1) {
                    counter++;
                } else {
                    //When it has stopped the amount of black pixels in a row is added to the array list.
                    if (counter > 0) {
                        total.add(counter);
                        counter = 0;
                    }
                }
            }
        
            //If counter still has excess numbers then add to the array list (total)
            if (counter > 0) {
                total.add(counter);
                counter = 0;
            }
        }
        System.out.println(rowMap.entrySet());
        //Same logic as above but for columns.
        for (int y = 0; y < 15; y++) {
            List<Integer> total = new ArrayList<>();
        
            columnMap.put(y, total);
            for (int x = 0; x < 15; x++) {
        
                if (solution[x][y] == 1) {
                    counter++;
                } else {
                    if (counter > 0) {
                        total.add(counter);
                        counter = 0;
                    }
                }
            }
        

            if (counter > 0) {
                total.add(counter);
                counter = 0;
            }
        }
        System.out.println(columnMap.entrySet());



        //Convverts numbers to strings and then passed to function in Grid class.
        for(int c = 0; c < 15; c++){

            String value = rowMap.get(c).toString();
            buttonR.grid.setLabelSide(c, value);
        }

        for(int d = 0; d < 15; d++){

            String value = columnMap.get(d).toString();
            buttonR.grid.setLabelTop(d, value);
        }
    }



    




}
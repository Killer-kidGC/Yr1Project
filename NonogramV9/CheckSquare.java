
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
        rangeX = 15;
        rangeY = 15;
        setSolution();
        buttonR = new ButtonReact(solution);

        

        

    }

    private void setSolution(){
        // -1 = Grey
        // 0 = Black
        // 1 = White


        solution = read.getAnswer();

        /*for (int i = 0; i < rangeX; i++){

            for (int j = 0; j < rangeY; j++){
                // System.out.println("lol" + buttonR.getFilledArray()[i][j]);
                solution[i][j] = -1;

            }

        }*/
        //solution[0][1] = 0;
        //solution[0][0] = 0;



    }

    public int[][]getSolution(){

        return this.solution;
    }



}

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



}
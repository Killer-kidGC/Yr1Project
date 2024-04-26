import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
public class Main {
    
    public static void main(String[] args) {
    
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900,1000);
    frame.setLayout(new GridLayout(15,15,10,10));

    JButton[][] tiles = new JButton[15][15];

    ImageIcon blank = new ImageIcon("blank.jpg");


    for (int i = 0; i < 15; i++ ){

        for (int j = 0; j < 15; j++){
            
            tiles[i][j] = new JButton(blank);
            frame.add(tiles[i][j]);
        }
    }

    frame.setVisible(true);



        
    }
}
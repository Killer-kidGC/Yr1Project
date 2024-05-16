
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ReadFile {
   int[][] answer;
   int imgWidth;
   int imgHeight;

   public ReadFile() {
      try{

         String Path = "elephant.BMP";
         BufferedImage elephantBW = ImageIO.read(new File(Path));

         //Takes dimensions from the image data.
         imgWidth = elephantBW.getWidth();
         imgHeight = elephantBW.getHeight();

         int pixel;

         answer = new int[imgWidth][imgHeight];

         //Iterates through each pixel so that its colour data can be extracted.
         for (int i = 0; i < imgWidth; i++) {

            for(int j = 0; j < imgHeight; j++){

               int colour = elephantBW.getRGB(i, j);

               //Defines colour values.
               int red = (colour >> 16) & 0xFF;
               int green = (colour >> 8) & 0xFF;
               int blue = colour & 0xFF;

               //checks whether the pixel is black or white and assigns it a value so that the colour can be added to an array and understood by the rest of the program.
               if (red == 250 &&  green == 250 && blue == 250) {
                   pixel = 1;

               }

               else if(red == 0 && green == 0 && blue == 0){

                  pixel = 0;
               }

               else{

                  pixel = 1;
               }

               //Adds the colour value (black or white) to an array so that it can then be accessed by the CheckSquare class.
               answer[j][i] = pixel;

            }

         }


         
      } catch (IOException e) {
         e.printStackTrace();
      }
      

   }

   public int[][] getAnswer(){

      return answer;

   }

   public int getHeight(){

      return imgHeight;
   }

   public int getWidth(){

      return imgWidth;
   }
    
    


}
package converttopixelmatrix;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Conversion
{
  public static void main(String args[]) throws IOException
  {
    BufferedImage image = ImageIO.read(new File("path"));
    Raster raster = image.getData();
    int h = raster.getHeight();
    int w = raster.getWidth();
    int pixels[][] = new int [w][h];
    
    for(int x = 0; x < w; x++){
      for(int y = 0; y < h; y++){
        if(pixels[y][x] != 0)
        {
          System.out.print(" ");
        } else {
          System.out.print("1 ")
        }
      }
      System.out.println();
    }
  }
}
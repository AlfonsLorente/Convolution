/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolution;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author alfon
 */
public class Convolution extends BufferedImage{
    
    private BufferedImage bufferedImage;
    private int[][] pixels;
    private int[][] kernel;
    private int width;
    private int height;
    
    
    Convolution(BufferedImage bufferedImage){
        this.bufferedImage = bufferedImage;
        width = bufferedImage.getWidth();
        height = bufferedImage.getHeight();
        pixels = new int [width-1][height-1];
        fillPixels();
    }
    
    private void sharpening(){
        kernel = new int[][] {
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
        };
        
        for(int i = 1; i < width-1; i++){
            for(int j = 1; j < height-1; j++){
                
            }
        }
        
        
        
    }

    private void fillPixels() {
         for(int i = 1; i < width-1; i++){
            for(int j = 1; j < height-1; j++){
            }
         }
    }
    
    
    
    
}

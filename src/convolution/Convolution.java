/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolution;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author alfon
 */
public class Convolution{
    private BufferedImage image;
    private BufferedImage convolutedImage;
    private int[][] redList;
    private int[][] greenList;
    private int[][] blueList;
    private int[][] alphaList;
    
    private int[][] kernel;
    private int kernelSum = 0;

    private int width;
    private int height;
    private boolean modRed = true;
    private boolean modGreen = true;
    private boolean modBlue = true;
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;


    enum Type{
        SHARPENING
    }
    
    
    public Convolution(BufferedImage image, Type type, boolean modRed, boolean modGreen, boolean modBlue){
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
        convolutedImage = new BufferedImage(width-2, height-2, image.getType());
        redList = new int[width][height];
        greenList = new int[width][height];
        blueList = new int[width][height];
        alphaList = new int[width][height];
        fillColorLists();
        
        
    }

    public BufferedImage getConvolutedImage() {
        return convolutedImage;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    
    private void sharpening(){
        kernel = new int[][] {
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
        };
        
        applyConvolution();
    }

    private void fillColorLists() {
         for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                redList[i][j] = new Color(image.getRGB(i, j)).getRed();
                greenList[i][j] = new Color(image.getRGB(i, j)).getGreen();
                blueList[i][j] = new Color(image.getRGB(i, j)).getBlue();
                alphaList[i][j] = new Color(image.getRGB(i, j)).getAlpha();


            }
         }
    }

    private void applyConvolution() {
        applyKernelSum();
        
        for(int i = 1; i < width-1; i++){
            for(int j = 1; j < height-1; j++){
                if(modRed) evolveColor(i, j, RED);
                if(modGreen) evolveColor(i, j, GREEN);
                if(modBlue) evolveColor(i, j, BLUE);
                
            }
        }
    }

    private void evolveColor(int i, int j, int colorMod) {
        int[][] colorList;
        int color, pixel;
        if(colorMod == RED) colorList = redList;
        else if(colorMod == GREEN) colorList = greenList;
        else colorList = blueList;
        
        color = (
                (colorList[i-1][j-1]*kernel[0][0]) + 
                (colorList[i-1][j-0]*kernel[0][1]) + 
                (colorList[i-1][j+1]*kernel[0][2]) + 
                (colorList[i+0][j-1]*kernel[1][0]) + 
                (colorList[i+0][j-0]*kernel[1][1]) + 
                (colorList[i+0][j+1]*kernel[1][2]) + 
                (colorList[i+1][j-1]*kernel[2][0]) + 
                (colorList[i+1][j-0]*kernel[2][1]) + 
                (colorList[i+1][j+1]*kernel[2][2])
                ) / kernelSum;
        if(color > 255) color = 255;
        
        if(colorMod == RED) pixel = (alphaList[i][j]<<24) | (color<<16) | (greenList[i][j]<<8) | blueList[i][j];
        else if(colorMod == GREEN) pixel = (alphaList[i][j]<<24) | (redList[i][j]<<16) | (color<<8) | blueList[i][j];
        else pixel = (alphaList[i][j]<<24) | (redList[i][j]<<16) | (greenList[i][j]<<8) | blueList[i][j];
        convolutedImage.setRGB(i-1, j-1, pixel);
        
    }
    
    private void applyKernelSum() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                kernelSum += kernel[i][j];
            }
        }
        if (kernelSum < 1) kernelSum = 1;
        
    }




    
    
    
    
}

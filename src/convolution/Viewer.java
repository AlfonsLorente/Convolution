/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolution;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author alfon
 */
public class Viewer extends JPanel{
    private BufferedImage image;
    private BufferedImage convolutedImage;
    
    public Viewer(){
        this.setBackground(Color.black);

    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getConvolutedImage() {
        return convolutedImage;
    }

    public void setConvolutedImage(BufferedImage convolutedImage) {
        this.convolutedImage = convolutedImage;
    }
    
    

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        g.drawImage(convolutedImage, 0, 0, this);
    }
    
    
    
}

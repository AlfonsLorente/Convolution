/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolution;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
        this.setLayout(new GridBagLayout());
        
        
        
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
        setUpRawImage();
        setUpConvolutedImage();
        
    }
    
    



    private void setUpRawImage() {
        GridBagConstraints constraints = new GridBagConstraints(); 
        JLabel rawImageLabel = new JLabel(new ImageIcon(image));
        constraints.gridx = 0; 
        constraints.gridy = 0; 
        constraints.weightx = 1;
        constraints.weighty = 0.05;
        constraints.gridwidth = 1;
        add(rawImageLabel, constraints);
        
    }
    
    private void setUpConvolutedImage() {
        GridBagConstraints constraints = new GridBagConstraints(); 
        JLabel convolutedImageLabel = new JLabel(new ImageIcon(convolutedImage));
        constraints.gridx = 1; 
        constraints.gridy = 0; 
        constraints.weightx = 1;
        constraints.weighty = 0.05;
        constraints.gridwidth = 1;
        add(convolutedImageLabel, constraints);
        
    }
    
    
        
   /* @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }*/
    
}

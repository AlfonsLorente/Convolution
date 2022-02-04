/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolution;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferStrategy;
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
public class Viewer extends Canvas implements Runnable{

    private BufferedImage image;
    private BufferedImage convolutedImage;

    public Viewer() {
        this.setBackground(Color.black);
        //this.setLayout(new GridBagLayout());

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

   /* @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setUpRawImage();
        setUpConvolutedImage();

    }*/
    //paint: Draw the flames and the background image
    public void paint(){
        //The buffered strategy trys to prevent flickering
        //Uses the buffered strategy
        BufferStrategy bs = this.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        if (bs==null){
            return;
        }
        if (g==null){
            return;
        }
        g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1400, 1000);
        g.drawImage(image.getScaledInstance(650, -1, BufferedImage.SCALE_SMOOTH), 0, 150, this);
        g.drawImage(convolutedImage.getScaledInstance(650, -1, BufferedImage.SCALE_SMOOTH), 600, 150, this);
        
        bs.show();
        g.dispose();
    }
        
    


    //run: Called by the thread, it runs the paint function
    @Override
    public void run() {
        //Initial sleep to prevent pair error
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        //implements the buffer strategy
        createBufferStrategy(2);
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        }
            paint();
        }
    }

}

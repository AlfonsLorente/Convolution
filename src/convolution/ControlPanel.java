/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolution;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author alfon
 */
public class ControlPanel extends JPanel implements ActionListener{
    //DECLARE VARIABLES
    private JButton convolutionButton;
    private JLabel title;
    private JMenu convolutionMenu;
    private JMenuItem i1, i2, i3, i4, i5, i6;
    private JMenuBar convolutionMenuBar =new JMenuBar();  
    private MyTask main;
    private Border line = new LineBorder(Color.RED);
    private Border margin = new EmptyBorder(5, 15, 5, 15);
    private Border compound = new CompoundBorder(line, margin);
    private BufferedImage bufferedImage;
    
    
    

    //CONSTRUCTOR
    public ControlPanel() {
        
        //SET UP THE CONTROLPANEL
        controlPanelSetUp();
        titleSetUp();
        convoluterSetUp();

        
    }
    
    //PUBLIC METHODS
    //Getters and setters
    public void setMain(MyTask main) {
        this.main = main;
    }
    
    //PROTECTED METHODS
    //paintComponent: Paints the background
    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, null);
    }
    
    //PRIVATE METHODS
    //contolPanelSetUp: sets the base of this class
    private void controlPanelSetUp() {
        
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.decode("#A020F0"));
        this.setVisible(true);
        
    }
    
    //titleSetUp: set up the title
    private void titleSetUp() {
        //Declare the grid bag constraints
        GridBagConstraints constraints = new GridBagConstraints();  
        //Set up title
        title = new JLabel("IMAGE CONVOLUTION");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setOpaque(true);
        title.setBackground(Color.BLACK);
        //set up constraints
        constraints.gridx = 0; 
        constraints.gridy = 0; 
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.gridwidth = 2;
        //set the title
        this.add(title, constraints);
    }

    
    //stopSetUp
    private void convoluterSetUp() {
        setConvolutionList();
       // setconvolutionButton();
       
        
        
        
    }

    private void setConvolutionList() {
        GridBagConstraints constraints = new GridBagConstraints();  
        convolutionMenu=new JMenu("Convolution type");  
        i1=new JMenuItem("Sharpen");  
        i2 = new JMenuItem("Smooth");
        i3 = new JMenuItem("Raise");
        i4=new JMenuItem("Outline");  
        i5 = new JMenuItem("Emboss");
        i6 = new JMenuItem("Blur");
        convolutionMenu.add(i1);
        convolutionMenu.add(i2);
        convolutionMenu.add(i3);
        convolutionMenu.add(i4);
        convolutionMenu.add(i5);
        convolutionMenu.add(i6);
        convolutionMenuBar.add(convolutionMenu);
        

        //set up constraints
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.gridwidth = 1;
        this.add(convolutionMenuBar, constraints);
        
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i6.addActionListener(this);
        
    }
/*
    private void setconvolutionButton() {

        //Declare the grid bag constraints
        GridBagConstraints constraints = new GridBagConstraints();  
        
        //set up stop
        convolutionButton = new JButton("CONVOLUTE");
        convolutionButton.setBorderPainted(true);
        convolutionButton.setFocusPainted(false);
        convolutionButton.setContentAreaFilled(true);
        convolutionButton.setBackground(Color.WHITE);
        convolutionButton.setForeground(Color.BLACK);
        convolutionButton.setBorder(compound);
        
        
        //set up constraints
        constraints.gridx = 1; 
        constraints.gridy = 1; 
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.gridwidth = 1;
        this.add(convolutionButton , constraints);
        //add the button listener
        convolutionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
        
*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Sharpen")){
            main.changeConvolutedImage(Convolution.Type.SHARPEN);
            
            
        }else if(e.getActionCommand().equals("Smooth")){
            main.changeConvolutedImage(Convolution.Type.SMOOTH);
            
        }else if(e.getActionCommand().equals("Raise")){
            main.changeConvolutedImage(Convolution.Type.RAISE);
            
            
        }else if(e.getActionCommand().equals("Outline")){
            main.changeConvolutedImage(Convolution.Type.OUTLINE);
            
        }else if(e.getActionCommand().equals("Emboss")){
            main.changeConvolutedImage(Convolution.Type.EMBOSS);
            
        }else if(e.getActionCommand().equals("Blur")){
            main.changeConvolutedImage(Convolution.Type.BLUR);
            
        }
    }
    
        
}

    
    

    
    


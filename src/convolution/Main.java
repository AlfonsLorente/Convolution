/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convolution;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

/**
 *
 * @author alfon
 */
public class Main extends JFrame{

    private GridBagConstraints constraints = new GridBagConstraints(); 
    
    
    public static void main(String[] args) {
        new Main();
    }
    
    
    Main(){
        setMainFrame();
        this.setVisible(true);
        
        
    }

    private void setMainFrame() {
        this.setTitle("ConvolutionTransform");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout (null);
        this.setBounds(0, 0, 1360, 790);
        this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        //this.setResizable(false);        
        
    }
    
     //setGridRules: set up the gridbag layout rules
    private void setGridRules(){
        //Set the constraints up for the viewer
        constraints.gridx = 1; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        //Add the viewer with the contraints.
        //this.add(viewer , constraints);
        
        //Set the constraints up for the control panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 1;
        //Add the control panel with the contraints.
        //is.add (controlPanel, constraints);

    }
    
    
}

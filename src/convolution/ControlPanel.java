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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author alfon
 */
public class ControlPanel extends JPanel implements ActionListener {

    //DECLARE VARIABLES
    private JButton fileChooserButton;
    private JLabel title, colorChooserLabel;
    private JMenu convolutionMenu;
    private JMenuItem i1, i2, i3, i4, i5, i6;
    private JMenuBar convolutionMenuBar = new JMenuBar();
    private MyTask myTask;
    private Border line = new LineBorder(Color.RED);
    private Border margin = new EmptyBorder(5, 15, 5, 15);
    private Border compound = new CompoundBorder(line, margin);
    private BufferedImage bufferedImage;
    private JCheckBox redCheckbox, greenCheckbox, blueCheckbox;
    private JFileChooser fileChooser;
    
    

    //CONSTRUCTOR
    public ControlPanel() {

        //SET UP THE CONTROLPANEL
        controlPanelSetUp();
        titleSetUp();
        fileChooserSetUp();
        userTextInputSetUp();
        convoluterSetUp();
        

    }

    //PUBLIC METHODS
    //Getters and setters
    public void setMain(MyTask myTask) {
        this.myTask = myTask;
    }

    //PROTECTED METHODS
    //paintComponent: Paints the background


    //PRIVATE METHODS
    //contolPanelSetUp: sets the base of this class
    private void controlPanelSetUp() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.RED.darker().darker().darker().darker());
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
        title.setBackground(Color.BLACK);
        title.setOpaque(true);
        //set up constraints
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.1;
        constraints.weighty = 1;
        constraints.gridwidth = 3;
        //set the title
        this.add(title, constraints);
    }

    
    private void fileChooserSetUp() {
        GridBagConstraints constraints = new GridBagConstraints();
        fileChooserButton = new JButton("Choose an image");
        fileChooserButton.setBorderPainted(true);
        fileChooserButton.setFocusPainted(false);
        fileChooserButton.setContentAreaFilled(true);
        fileChooserButton.setBackground(Color.WHITE);
        fileChooserButton.setForeground(Color.BLACK);
        fileChooserButton.setBorder(compound);
         //set up constraints
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridwidth = 3;
        
        this.add(fileChooserButton, constraints);
        fileChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser("C:\\Users\\pc\\Documents\\", FileSystemView.getFileSystemView());
                int r = fileChooser.showSaveDialog(null);
 
            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION){
                // set the label to the path of the selected file
                myTask.changeImage(fileChooser.getSelectedFile().getAbsolutePath()); 
            }
                
            }
        });
        
    }
    
    
       
    private void userTextInputSetUp() {
        GridBagConstraints constraintsLabel = new GridBagConstraints();
        JLabel textInputTitle = new JLabel("Set your own filter: ");
        
        fileChooserButton.setContentAreaFilled(true);
        textInputTitle.setForeground(Color.WHITE);
         //set up constraints
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 2;
        constraintsLabel.weightx = 1;
        constraintsLabel.weighty = 0.5;
        constraintsLabel.gridwidth = 3;
        this.add(textInputTitle, constraintsLabel);
        
        
        JTextField textInput1 = setTextInput(0,3);
        JTextField textInput2 = setTextInput(1,3);
        JTextField textInput3 = setTextInput(2,3);
        JTextField textInput4 = setTextInput(0,4);
        JTextField textInput5 = setTextInput(1,4);
        JTextField textInput6 = setTextInput(2,4);
        JTextField textInput7 = setTextInput(0,5);
        JTextField textInput8 = setTextInput(1,5);
        JTextField textInput9 = setTextInput(2,5);
        
        
        GridBagConstraints constraintsDivText = new GridBagConstraints();
        JLabel divText = new JLabel("Division: ");
        divText.setForeground(Color.WHITE);
         //set up constraints
        constraintsDivText.gridx = 0;
        constraintsDivText.gridy = 6;
        constraintsDivText.weightx = 1;
        constraintsDivText.weighty = 0.5;
        constraintsDivText.gridwidth = 1;
        this.add(divText, constraintsDivText);
        
        JTextField divInput = setTextInput(1,6);
        
        
        GridBagConstraints constraintsButton = new GridBagConstraints();
        JButton sendTextInput = new JButton("Send");
        sendTextInput.setBorderPainted(true);
        sendTextInput.setFocusPainted(false);
        sendTextInput.setContentAreaFilled(true);
        sendTextInput.setBackground(Color.WHITE);
        sendTextInput.setForeground(Color.BLACK);
        sendTextInput.setBorder(compound);
         //set up constraints
        constraintsButton.gridx = 2;
        constraintsButton.gridy = 6;
        constraintsButton.weightx = 1;
        constraintsButton.weighty = 0.5;
        constraintsButton.gridwidth = 1;
        
        this.add(sendTextInput, constraintsButton);
        sendTextInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float[][] kernel = new float[3][3];
                kernel[0][0] = Float.parseFloat(textInput1.getText().toString());
                kernel[0][1] = Float.parseFloat(textInput2.getText().toString());
                kernel[0][2] = Float.parseFloat(textInput3.getText().toString());
                kernel[1][0] = Float.parseFloat(textInput4.getText().toString());
                kernel[1][1] = Float.parseFloat(textInput5.getText().toString());
                kernel[1][2] = Float.parseFloat(textInput6.getText().toString());
                kernel[2][0] = Float.parseFloat(textInput7.getText().toString());
                kernel[2][1] = Float.parseFloat(textInput8.getText().toString());
                kernel[2][2] = Float.parseFloat(textInput9.getText().toString());
                float div = Float.parseFloat(divInput.getText().toString());
                myTask.changeConvolutionKernel(kernel, div);
                
                
            }
        });
        
    }
    
    
    private JTextField setTextInput(int x, int y ){
        GridBagConstraints constraints = new GridBagConstraints();
        JTextField tf = new JTextField("1");
        tf.setHorizontalAlignment(JTextField.CENTER);
        //set up constraints
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.weightx = 1;
        constraints.weighty = 0.3;
        constraints.gridwidth = 1;
        constraints.ipadx = 30;
        constraints.ipady = 30;

        this.add(tf, constraints);
        return tf;
        
        
    }

    
    
    
    //stopSetUp
    private void convoluterSetUp() {
        setConvolutionList();
        setConvolutionColor();

    }

    //setConvolutionList: Adds the menu of convolution types
    private void setConvolutionList() {
        GridBagConstraints constraints = new GridBagConstraints();
        convolutionMenu = new JMenu("Done filters");
        i1 = new JMenuItem("Sharpen");
        i2 = new JMenuItem("Smooth");
        i3 = new JMenuItem("Raise");
        i4 = new JMenuItem("Outline");
        i5 = new JMenuItem("Emboss");
        i6 = new JMenuItem("Blur");
        convolutionMenu.add(i1);
        convolutionMenu.add(i2);
        convolutionMenu.add(i3);
        convolutionMenu.add(i4);
        convolutionMenu.add(i5);
        convolutionMenu.add(i6);
        convolutionMenu.setForeground(Color.BLACK);


        convolutionMenuBar.add(convolutionMenu);
        convolutionMenuBar.setBorderPainted(true);
        convolutionMenuBar.setBackground(Color.WHITE);
        convolutionMenuBar.setForeground(Color.BLACK);
        convolutionMenuBar.setBorder(compound);

        //set up constraints
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridwidth = 3;
        this.add(convolutionMenuBar, constraints);

        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i6.addActionListener(this);

    }

    //actionPerformed: Get the menu item clicked on the convolution menu
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Sharpen")) {
            myTask.changeConvolutedImage(Convolution.Type.SHARPEN);

        } else if (e.getActionCommand().equals("Smooth")) {
            myTask.changeConvolutedImage(Convolution.Type.SMOOTH);

        } else if (e.getActionCommand().equals("Raise")) {
            myTask.changeConvolutedImage(Convolution.Type.RAISE);

        } else if (e.getActionCommand().equals("Outline")) {
            myTask.changeConvolutedImage(Convolution.Type.OUTLINE);

        } else if (e.getActionCommand().equals("Emboss")) {
            myTask.changeConvolutedImage(Convolution.Type.EMBOSS);

        } else if (e.getActionCommand().equals("Blur")) {
            myTask.changeConvolutedImage(Convolution.Type.BLUR);

        }
    }

    //setConvolutionColor: changes the color that will be convoluted with checkbox
    private void setConvolutionColor() {
        GridBagConstraints cLabel = new GridBagConstraints();
        colorChooserLabel = new JLabel("Colors to convolute");
        colorChooserLabel.setForeground(Color.white);
        //set up constraints
        cLabel.gridx = 0;
        cLabel.gridy = 8;
        cLabel.weightx = 0.1;
        cLabel.weighty = 0;
        cLabel.gridwidth = 3;
        this.add(colorChooserLabel, cLabel);
        
        GridBagConstraints cCheckBox = new GridBagConstraints();
        redCheckbox = new JCheckBox("Red");
        redCheckbox.setBackground(null);
        redCheckbox.setForeground(Color.WHITE);
        redCheckbox.setSelected(true);
        
        //set up constraints
        cCheckBox.gridx = 0;
        cCheckBox.gridy = 9;
        cCheckBox.weightx = 0.1;
        cCheckBox.weighty = 0.3;
        this.add(redCheckbox, cCheckBox);
        redCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    myTask.changeConvolutedImage("red", true);
                }else{
                    myTask.changeConvolutedImage("red", false);

                }
            }
        });
        
        greenCheckbox = new JCheckBox("Green");
        greenCheckbox.setBackground(null);
        greenCheckbox.setForeground(Color.WHITE);
        greenCheckbox.setSelected(true);
        cCheckBox.gridx = 1;
        this.add(greenCheckbox, cCheckBox);
        greenCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    myTask.changeConvolutedImage("green", true);
                }else{
                    myTask.changeConvolutedImage("green", false);

                }
            }
        });

        blueCheckbox = new JCheckBox("Blue");
        blueCheckbox.setBackground(null);
        blueCheckbox.setForeground(Color.WHITE);
        blueCheckbox.setSelected(true);
        cCheckBox.gridx = 2;
        this.add(blueCheckbox, cCheckBox);
        blueCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    myTask.changeConvolutedImage("blue", true);
                }else{
                    myTask.changeConvolutedImage("blue", false);

                }
            }
        });
    }

  
    
    
    
    

}

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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author alfon
 */
public class MyTask extends JFrame {

    private BufferedImage image;
    private BufferedImage convolutedImage;
    private Convolution convolution;
    private Viewer viewer;
    private ControlPanel controlPanel;
    private Convolution.Type convType = Convolution.Type.EMBOSS;
    private boolean redState = true, greenState = true, blueState = true;
    private Thread viewerThread;
    private String imageSrc = "IMG/taking_photo.png";
    private float[][] kernel = new float[3][3];
    private float kernelDiv = 1;

    public static void main(String[] args) {
        new MyTask();
    }

    public MyTask() {
        setMainFrame();
        setUpImages();
        setUpViewer();

        controlPanel = new ControlPanel();
        controlPanel.setMain(this);
        setGridRules();
        viewerThread = new Thread(viewer);
        viewerThread.start();
        this.setVisible(true);

    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Viewer getViewer() {
        return viewer;
    }

    private void setMainFrame() {
        this.setTitle("ConvolutionTransform");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setBounds(0, 0, 1550, 850);
        //this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        this.setResizable(false);

    }

    //setGridRules: set up the gridbag layout rules
    private void setGridRules() {
        //Set the constraints up for the viewer
        addViewer();
        addControlPanel();

    }

    private void setUpImages() {
        try {
            image = ImageIO.read(new File(imageSrc));
        } catch (IOException ex) {
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (convType.equals(Convolution.Type.PERSONALITZED)) {
            convolution = new Convolution(image, redState, greenState, blueState, kernel, kernelDiv);
        } else {
            convolution = new Convolution(image, convType, redState, greenState, blueState);
        }
        convolutedImage = convolution.getConvolutedImage();

    }

    public void changeConvolutedImage(Convolution.Type newType) {
        if (!convType.equals(newType)) {
            convType = newType;
            if (convType.equals(Convolution.Type.PERSONALITZED)) {
                convolution = new Convolution(image, redState, greenState, blueState, kernel, kernelDiv);

            } else {
                convolution = new Convolution(image, convType, redState, greenState, blueState);

            }
            convolutedImage = convolution.getConvolutedImage();
            viewer.setConvolutedImage(convolutedImage);

        }
    }

    public void changeConvolutedImage(String colorName, boolean colorState) {
        if (colorName.equals("red")) {
            redState = colorState;
        } else if (colorName.equals("green")) {
            greenState = colorState;
        } else if (colorName.equals("blue")) {
            blueState = colorState;
        }

        if (convType.equals(Convolution.Type.PERSONALITZED)) {
            convolution = new Convolution(image, redState, greenState, blueState, kernel, kernelDiv);
        } else {
            convolution = new Convolution(image, convType, redState, greenState, blueState);

        }
        convolutedImage = convolution.getConvolutedImage();
        viewer.setConvolutedImage(convolutedImage);

    }

    public void changeImage(String imageSrc) {
        this.imageSrc = imageSrc;
        setUpImages();
        viewer.setImage(image);
        viewer.setConvolutedImage(convolutedImage);

    }

    private void addViewer() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        //Add the viewer with the contraints.
        this.add(viewer, constraints);
    }

    private void addControlPanel() {
        GridBagConstraints constraints = new GridBagConstraints();
        //Set the constraints up for the control panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;

        //Add the control panel with the contraints.
        this.add(controlPanel, constraints);
    }

    private void setUpViewer() {
        viewer = new Viewer();
        viewer.setImage(image);
        viewer.setConvolutedImage(convolutedImage);
    }

    void changeConvolutionKernel(float[][] kernel, float div) {

        this.convType = Convolution.Type.PERSONALITZED;
        this.kernel = kernel;
        this.kernelDiv = div;
        convolution = new Convolution(image, redState, greenState, blueState, kernel, div);
        convolutedImage = convolution.getConvolutedImage();
        viewer.setConvolutedImage(convolutedImage);
    }

}

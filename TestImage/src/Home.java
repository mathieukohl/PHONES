import javax.swing.*;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.nio.ByteBuffer;

import static com.sun.javafx.iio.common.ImageTools.scaleImage;

class Home extends JFrame
{


    public Home() {

        setVisible(true);

        setLayout(new BorderLayout());

        JLabel background=new JLabel(new ImageIcon("C:\\Users\\Admin\\Documents\\HES-SO\\S2\\POO\\Projet Smartphone\\Images\\iPhone.jpg"));





        background.setSize(480,800);


        this.setResizable(false);

        background.setLayout(new FlowLayout());
        add(background);
        pack();

        this.setUndecorated(false);

    }

}
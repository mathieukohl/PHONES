package GUI_PHONE;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

import javax.swing.*;

public class HOME_SCREEN extends JFrame {

    private JPanel frame = new JPanel();
    private JPanel header = new JPanel();
    private JPanel main = new JPanel();
    private JPanel footer = new JPanel();

    private JLabel label = new JLabel ("Test");

    ImageIcon iphone = (new ImageIcon("C:\\Users\\Admin\\Documents\\HES-SO\\S2\\POO\\Projet Smartphone\\Images\\iPhone3.png"));

    JLabel frameIphone = new JLabel(iphone);

    ClockLabel timeLable = new ClockLabel("time");

   public HOME_SCREEN() {
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(480,800);
       setLayout(null);
       setLocationRelativeTo(null);
       //Impossible d'ajuster la taille de la fenêtre
       setResizable(false);

       //Ajout de la Frame qui va nous servir "d'écran de Smartphone"
       frame.setBounds(86,89,310,553);
       frame.setBackground(Color.red);
       frame.setVisible(true);
       add(frame);


       header.add(timeLable);
       header.setBackground(Color.black);
       header.setVisible(true);
       header.setBounds(0,0,310,50);
       frame.add(header);

       //Mettre un bouton avec une image
       ImageIcon homeButton = new ImageIcon("C:\\Users\\Admin\\Documents\\HES-SO\\S2\\POO\\Projet Smartphone\\Images\\homeButton.png");
       JButton button = new JButton(homeButton);
       button.setMargin(new Insets(0, 0, 0, 0));
       //button.setBorder(null);
       button.setBounds(218,651,50,50);
       button.setBackground(Color.white);
       add(button);


       // Ajout de l'image de l'iPhone qui va servir de fenêtre
       main.add(frameIphone);
       main.setSize(480,800);
       main.setVisible(true);
       add(main);


       /*
       footer.setSize(420,420);
       footer.setVisible(true);
       footer.setBackground(Color.black);
       main.add(footer, BorderLayout.SOUTH);*/


   }

       class ClockLabel extends JLabel implements ActionListener {

           String type;
           SimpleDateFormat sdf;

           public ClockLabel(String type) {
               this.type = type;
               setForeground(Color.white);

               switch (type) {
                   case "time":
                       sdf = new SimpleDateFormat("h:mm a");
                       setFont(new Font("sans-serif", Font.PLAIN, 10));
                       setHorizontalAlignment(SwingConstants.CENTER);
                       break;
                   default:
                       sdf = new SimpleDateFormat();
                       break;
               }

               Timer t = new Timer(1000, this);
               t.start();
           }

           public void actionPerformed(ActionEvent ae) {
               Date d = new Date();
               setText(sdf.format(d));
           }
       }
   }



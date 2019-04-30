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

    private ImageIcon iphone = (new ImageIcon("C:\\Users\\Admin\\Documents\\HES-SO\\S2\\POO\\Projet Smartphone\\Images\\iPhone3.png"));
    private ImageIcon homeButton = new ImageIcon("C:\\Users\\Admin\\Documents\\HES-SO\\S2\\POO\\Projet Smartphone\\Images\\homeButton.png");
    //private ImageIcon wallpaper = new ImageIcon("C:\\Users\\Admin\\Documents\\HES-SO\\S2\\POO\\Projet Smartphone\\Images\\WallpaperSpace.jpg");
    ImageIcon wallpaper = new ImageIcon(new ImageIcon("C:\\\\Users\\\\Admin\\\\Documents\\\\HES-SO\\\\S2\\\\POO\\\\Projet Smartphone\\\\Images\\\\WallpaperRoute.jpg").getImage().getScaledInstance(310, 500, Image.SCALE_DEFAULT));

    private JLabel frameIphone = new JLabel(iphone);
    private JLabel fondEcran = new JLabel(wallpaper);

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
       frame.setLayout(null);
       add(frame);

       //Ajout fond d'écrans sur la frame

       fondEcran.setBounds(0,25,310,478);
       fondEcran.setVisible(true);
       frame.add(fondEcran);

       //Ajout de la barre en haut de l'écran de l'Iphone
       header.add(timeLable);
       header.setBackground(Color.black);
       header.setVisible(true);
       header.setBounds(0,0,310,20);
       header.setSize(310,25);
       frame.add(header);

       //Mettre un bouton avec une image
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


       //Ajout de la barre en bas de l'écran de l'Iphone
       footer.setSize(420,420);
       footer.setVisible(true);
       footer.setBackground(Color.black);
       footer.setSize(310,50);
       footer.setBounds(0,503,310,50);
       footer.setOpaque(true);
       frame.add(footer);


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



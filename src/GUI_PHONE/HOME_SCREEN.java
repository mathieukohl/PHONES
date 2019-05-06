package GUI_PHONE;


import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.*;

public class HOME_SCREEN extends JPanel{

    private ImageIcon homeButton = new ImageIcon(new ImageIcon("/Users/KohlMathieu/IdeaProjects/PHONES/src/IMAGES/homeButton.jpeg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon galleryButton = new ImageIcon(new ImageIcon("/Users/KohlMathieu/IdeaProjects/PHONES/src/IMAGES/gallery.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon contactButton = new ImageIcon(new ImageIcon("/Users/KohlMathieu/IdeaProjects/PHONES/src/IMAGES/contact.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

    private ImageIcon wallpaper = new ImageIcon(new ImageIcon("/Users/KohlMathieu/IdeaProjects/PHONES/src/IMAGES/Wallpaper.jpeg").getImage().getScaledInstance(310, 525, Image.SCALE_DEFAULT));

    private JLabel fondEcran = new JLabel(wallpaper);

    private JButton buttonH = new JButton(homeButton);
    private JButton buttonC = new JButton(contactButton);
    private JButton buttonG = new JButton(galleryButton);



    public HOME_SCREEN() {


        //Ajout fond d'écrans sur la frame
        fondEcran.setBounds(0,0,310,525);
        fondEcran.setVisible(true);
        fondEcran.setLayout(null);
        add(fondEcran);


        //Ajout du bouton Home avec image
        buttonH.setMargin(new Insets(0, 0, 0, 0));
        buttonH.setBorder(null);
        buttonH.setBounds(218,651,50,50);
        buttonH.setBackground(Color.white);
        buttonH.setVisible(true);
        add(buttonH);


        //Ajout du bouton Gallery avec image
        buttonG.setMargin(new Insets(0, 0, 0, 0));
        buttonG.setBorder(null);
        buttonG.setBounds(10,10,50,50);
        buttonG.setVisible(true);
        fondEcran.add(buttonG);


        //Ajout du bouton Contact avec image
        buttonC.setMargin(new Insets(0, 0, 0, 0));
        buttonC.setBorder(null);
        buttonC.setBounds(70,10,50,50);
        buttonC.setVisible(true);
        fondEcran.add(buttonC);

    }
}
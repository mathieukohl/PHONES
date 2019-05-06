package CONTACT;


import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.*;

public class NEWCONTACT_APP extends JPanel {


        private ImageIcon homeButton = new ImageIcon(new ImageIcon("/Users/KohlMathieu/IdeaProjects/PHONES/src/IMAGES/homeButton.jpeg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        private ImageIcon galleryButton = new ImageIcon(new ImageIcon("/Users/KohlMathieu/IdeaProjects/PHONES/src/IMAGES/gallery.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        private ImageIcon contactButton = new ImageIcon(new ImageIcon("/Users/KohlMathieu/IdeaProjects/PHONES/src/IMAGES/contact.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        private ImageIcon wallpaper = new ImageIcon(new ImageIcon("/Users/KohlMathieu/IdeaProjects/PHONES/src/IMAGES/Wallpaper.jpeg").getImage().getScaledInstance(310, 525, Image.SCALE_DEFAULT));

        private JLabel fondEcran = new JLabel(wallpaper);

        private JButton buttonH = new JButton(homeButton);
        private JButton buttonC = new JButton(contactButton);
        private JButton buttonG = new JButton(galleryButton);

        private JPanel frameContact = new JPanel();

        private JLabel NomContact = new JLabel("Nom");
        private JLabel PrenomContact = new JLabel("Prenom");
        private JLabel AdressContact = new JLabel("Adress");
        private JLabel MailContact = new JLabel("E-Mail");
        private JLabel NumContact = new JLabel("Numéro");

        private JTextField NomField = new JTextField(1);
        private JTextField PrenomField = new JTextField(1);
        private JTextField AdressField = new JTextField(1);
        private JTextField MailField = new JTextField(1);
        private JTextField NumField = new JTextField(1);


        private JButton buttonDone = new JButton("DONE");



    public NEWCONTACT_APP(){

        frameContact.setSize(310,543);
        frameContact.setLayout(new GridLayout(6,2));
        frameContact.setBackground(Color.gray);
        frameContact.setVisible(true);
        frameContact.add(NomContact);
        frameContact.add(NomField);
        frameContact.add(PrenomContact);
        frameContact.add(PrenomField);
        frameContact.add(AdressContact);
        frameContact.add(AdressField);
        frameContact.add(MailContact);
        frameContact.add(MailField);
        frameContact.add(NumContact);
        frameContact.add(NumField);
        frameContact.add(buttonDone);
        add(frameContact);


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


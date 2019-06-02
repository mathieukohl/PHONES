package GUI_PHONE;


import CALCULATRICE.CALCULATRICE_APP;
import CONTACT.Contact;
import GALLERY.HOMEGALLERY;


import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.*;

public class HOME_SCREEN extends JPanel {

    //IMAGES
    // private ImageIcon homeButton = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\homeButton.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon galleryButton = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\gallery.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon contactButton = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\Contacts.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon calculateButton = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\calculatrice.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon wallpaper = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\Wallpaper.jpg").getImage().getScaledInstance(310, 525, Image.SCALE_DEFAULT));
    private ImageIcon eteindre = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\deleteb.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));


    //LABEL
    private JLabel fondEcran = new JLabel(wallpaper);
    private JPanel panel = new JPanel();

    //BUTTON
    private JButton buttonC = new JButton(contactButton);
    private JButton buttonG = new JButton(galleryButton);
    private JButton buttonCalculatrice = new JButton(calculateButton);
    public JButton buttonEteindre = new JButton(eteindre);



    private PHONE phone;
    private HOMEGALLERY homegallery;// = new HOMEGALLERY();
    private Contact contact_app;// = new Contact();
    private CALCULATRICE_APP calculatrice_app; //= new CALCULATRICE_APP();


    public HOME_SCREEN(PHONE phone, Contact contact_app, CALCULATRICE_APP calculatrice_app, HOMEGALLERY homegallery, JLabel fondEcran, JButton buttonC, JButton buttonG, JButton buttonCalculatrice, JButton buttonEteindre) {

        //SONGA OFFSHORE

        this.phone=phone;
        this.contact_app=contact_app;
        this.calculatrice_app=calculatrice_app;
        this.homegallery=homegallery;

        setLayout(null);
        setBounds(86, 120, 310, 520);
        setBackground(Color.white);

        //Ajout d'un panel pour implémenter la page NewContact
        add(contact_app);
        contact_app.readContact();
        contact_app.setVisible(false);



        add(calculatrice_app);
        calculatrice_app.setVisible(false);

        add(homegallery);
        homegallery.setVisible(false);



        //Ajout fond d'écrans sur la frame
        fondEcran.setBounds(0, 0, 310, 525);
        fondEcran.setVisible(true);
        fondEcran.setLayout(null);
        add(fondEcran);


        //Ajout du bouton Gallery avec image
        buttonG.setMargin(new Insets(0, 0, 0, 0));
        buttonG.setBorder(null);
        buttonG.setBounds(10, 10, 50, 50);
        buttonG.setBackground(new Color(0, 0, 0, 0));
        buttonG.setVisible(true);
        buttonG.addActionListener(new ButtonListenerGallery());
        fondEcran.add(buttonG);


        //Ajout du bouton Contact avec image
        buttonC.setMargin(new Insets(0, 0, 0, 0));
        buttonC.setBorder(null);
        buttonC.setBounds(70, 10, 50, 50);
        buttonC.setBackground(new Color(0, 0, 0, 0));
        buttonC.addActionListener(new ButtonListenerContact());
        buttonC.setVisible(true);
        fondEcran.add(buttonC);

        //Ajout du bouton Contact avec image
        buttonCalculatrice.setMargin(new Insets(0, 0, 0, 0));
        buttonCalculatrice.setBorder(null);
        buttonCalculatrice.setBounds(130, 10, 50, 50);
        buttonCalculatrice.setBackground(new Color(0, 0, 0, 0));
        buttonCalculatrice.addActionListener(new ButtonListenerCalculatrice());
        buttonCalculatrice.setVisible(true);
        fondEcran.add(buttonCalculatrice);


        //Ajout du bouton Eteindre avec image
        buttonEteindre.setBorder(null);
        buttonEteindre.setMargin(new Insets(0,0,0,0));
        buttonEteindre.setBackground(new Color(0,0,0,0));
        buttonEteindre.setFocusPainted(false);
        buttonEteindre.setBorderPainted(false);
        buttonEteindre.setContentAreaFilled(false);
        buttonEteindre.setBounds(190, 10, 50, 50);
        buttonEteindre.setVisible(true);
        buttonEteindre.addActionListener(new ButtonListenerEteindre());
        fondEcran.add(buttonEteindre);

    }

    public class ButtonListenerContact implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            fondEcran.setVisible(false);
            buttonEteindre.setVisible(false);
            buttonC.setVisible(false);
            buttonCalculatrice.setVisible(false);
            buttonG.setVisible(false);
            setVisible(false);
            contact_app.setVisible(true);

        }
    }

    public class ButtonListenerCalculatrice implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            fondEcran.setVisible(false);
            buttonEteindre.setVisible(false);
            buttonC.setVisible(false);
            buttonCalculatrice.setVisible(false);
            buttonG.setVisible(false);
            setVisible(false);
            calculatrice_app.setVisible(true);

        }
    }

    public class ButtonListenerGallery implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            fondEcran.setVisible(false);
            buttonEteindre.setVisible(false);
            buttonC.setVisible(false);
            buttonCalculatrice.setVisible(false);
            buttonG.setVisible(false);
            setVisible(false);
            homegallery.setVisible(true);
        }
    }

    public class ButtonListenerEteindre implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            phone.dispose();
            System.exit(0);
        }
    }




}
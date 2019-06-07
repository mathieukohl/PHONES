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

    /**
     * Création des images aux tailles souhaitées
     */
    //private ImageIcon galleryButton = (new ImageIcon(getClass().getResource("\\Gallery.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    private ImageIcon galleryButton = new ImageIcon(new ImageIcon(getClass().getResource("/gallery.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon contactButton = new ImageIcon(new ImageIcon(getClass().getResource("/Contacts.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon calculateButton = new ImageIcon(new ImageIcon(getClass().getResource("/calculatrice.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon wallpaper = new ImageIcon(new ImageIcon(getClass().getResource("/Wallpaper.jpg")).getImage().getScaledInstance(310, 525, Image.SCALE_DEFAULT));
    private ImageIcon eteindre = new ImageIcon(new ImageIcon(getClass().getResource("/Shutdown_button.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));


    /**
     * Création des JLAbel
     */
    private JLabel fondEcran = new JLabel(wallpaper);
    private JPanel panel = new JPanel();

    /**
     * Création des JBUtton
     */
    private JButton buttonC = new JButton(contactButton);
    private JButton buttonG = new JButton(galleryButton);
    private JButton buttonCalculatrice = new JButton(calculateButton);
    public JButton buttonEteindre = new JButton(eteindre);


    /**
     * Importation des classes dont on a besoin
     */
    private PHONE phone;
    private HOMEGALLERY homegallery;// = new HOMEGALLERY();
    private Contact contact_app;// = new Contact();
    private CALCULATRICE_APP calculatrice_app; //= new CALCULATRICE_APP();


    /**
     * Constructeur
     * @param phone
     * @param contact_app
     * @param calculatrice_app
     * @param homegallery
     * @param fondEcran
     * @param buttonC
     * @param buttonG
     * @param buttonCalculatrice
     * @param buttonEteindre
     */
    public HOME_SCREEN(PHONE phone, Contact contact_app, CALCULATRICE_APP calculatrice_app, HOMEGALLERY homegallery, JLabel fondEcran, JButton buttonC, JButton buttonG, JButton buttonCalculatrice, JButton buttonEteindre) {


        System.out.println(eteindre.getImage());
        this.phone=phone;
        this.contact_app=contact_app;
        this.calculatrice_app=calculatrice_app;
        this.homegallery=homegallery;

        /**
         * Mise en forme de la classe HOME_SCREEN
         */
        setLayout(null);
        setBounds(86, 120, 310, 520);
        setBackground(Color.white);

        /**
         * Ajout de l'application contact sur la frame et le setVisible false pour qu'il ne s'affiche pas tout de suite, mais quand on clique sur l'application
         */
        add(contact_app);
        contact_app.readContact();
        contact_app.setVisible(false);


        /**
         * Ajout de l'application calculatrice sur la frame et le setVisible false pour qu'il ne s'affiche pas tout de suite, mais quand on clique sur l'application
         */
        add(calculatrice_app);
        calculatrice_app.setVisible(false);

        /**
         * Ajout de l'application homegallery sur la frame et le setVisible false pour qu'il ne s'affiche pas tout de suite, mais quand on clique sur l'application
         */
        add(homegallery);
        homegallery.setVisible(false);


        /**Ajout fond d'écrans sur la frame
         *
         */
        fondEcran.setBounds(0, 0, 310, 525);
        fondEcran.setVisible(true);
        fondEcran.setLayout(null);
        add(fondEcran);


        /**Ajout du bouton Gallery avec image
         *
         */
        buttonG.setMargin(new Insets(0, 0, 0, 0));
        buttonG.setBorder(null);
        buttonG.setBounds(10, 10, 50, 50);
        buttonG.setBackground(new Color(0, 0, 0, 0));
        buttonG.setVisible(true);
        buttonG.addActionListener(new ButtonListenerGallery());
        fondEcran.add(buttonG);


        /**Ajout du bouton Contact avec image
         *
         */
        buttonC.setMargin(new Insets(0, 0, 0, 0));
        buttonC.setBorder(null);
        buttonC.setBounds(70, 10, 50, 50);
        buttonC.setBackground(new Color(0, 0, 0, 0));
        buttonC.addActionListener(new ButtonListenerContact());
        buttonC.setVisible(true);
        fondEcran.add(buttonC);

        /**Ajout du bouton Contact avec image
         *
         */
        buttonCalculatrice.setMargin(new Insets(0, 0, 0, 0));
        buttonCalculatrice.setBorder(null);
        buttonCalculatrice.setBounds(130, 10, 50, 50);
        buttonCalculatrice.setBackground(new Color(0, 0, 0, 0));
        buttonCalculatrice.addActionListener(new ButtonListenerCalculatrice());
        buttonCalculatrice.setVisible(true);
        fondEcran.add(buttonCalculatrice);


        /**Ajout du bouton Eteindre avec image
         *
         */
        buttonEteindre.setBorder(null);
        buttonEteindre.setMargin(new Insets(0,0,0,0));
        buttonEteindre.setBackground(new Color(0,0,0,0));
        buttonEteindre.setFocusPainted(false);
        buttonEteindre.setBorderPainted(false);
        buttonEteindre.setContentAreaFilled(false);
        buttonEteindre.setBounds(248, 460, 50, 50);
        buttonEteindre.setVisible(true);
        buttonEteindre.addActionListener(new ButtonListenerEteindre());
        fondEcran.add(buttonEteindre);

    }

    /**
     * ActionListener permettant de lancer l'application Contact
     */
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

    /**
     * ActionListener permettant de lancer l'application Calculatrice
     */
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

    /**
     * ActionListener permettant de lancer l'application Gallerie photo
     */
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

    /**
     * ActionListener permettant de fermer l'application lorsqu'on clique sur l'icone Eteindre
     */
    public class ButtonListenerEteindre implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            phone.dispose();
            System.exit(0);
        }
    }




}
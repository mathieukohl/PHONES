package CONTACT;


import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.*;

public class NEWCONTACT_APP extends JPanel {


        private ImageIcon addButton = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\add.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));


        private JTextField NomField = new JTextField("Nom",1);
        private JTextField PrenomField = new JTextField("Prenom",1);
        private JTextField AdressField = new JTextField("Adresse",1);
        private JTextField MailField = new JTextField("E-mail",1);
        private JTextField NumField = new JTextField("Numéro",1);

        private JButton buttonDone = new JButton("Done");
        private JButton buttonCancel = new JButton("Cancel");
        private JButton addPhoto = new JButton(addButton);



    public NEWCONTACT_APP(){


        setVisible(true);
        setLayout(null);
        setBackground(Color.white);
        setBounds(86,120,310,520);


        NomField.setMargin(new Insets(0, 0, 0, 0));
        NomField.setBorder(null);
        NomField.setBounds(10,20,150,30);
        NomField.setBackground(new Color(250,250,250));
        NomField.setVisible(true);
        add(NomField);

        PrenomField.setMargin(new Insets(0, 0, 0, 0));
        PrenomField.setBorder(null);
        PrenomField.setBounds(10,60,150,30);
        PrenomField.setBackground(new Color(250,250,250));
        PrenomField.setVisible(true);
        add(PrenomField);

        addPhoto.setMargin(new Insets(0, 0, 0, 0));
        addPhoto.setBorder(null);
        addPhoto.setBounds(230,20,50,50);
        addPhoto.setBackground(new Color(0,0,0,0)); //transparent
        addPhoto.setVisible(true);
        add(addPhoto);

        AdressField.setMargin(new Insets(0, 0, 0, 0));
        AdressField.setBorder(null);
        AdressField.setBounds(10,100,280,30);
        AdressField.setBackground(new Color(250,250,250));
        AdressField.setVisible(true);
        add(AdressField);

        MailField.setMargin(new Insets(0, 0, 0, 0));
        MailField.setBorder(null);
        MailField.setBounds(10,140,280,30);
        MailField.setBackground(new Color(250,250,250));
        MailField.setVisible(true);
        add(MailField);

        NumField.setMargin(new Insets(0, 0, 0, 0));
        NumField.setBorder(null);
        NumField.setBounds(10,180,280,30);
        NumField.setBackground(new Color(250,250,250));
        NumField.setVisible(true);
        add(NumField);

        buttonDone.setMargin(new Insets(0, 0, 0, 0));
        buttonDone.setBorder(null);
        buttonDone.setBounds(260,220,30,30);
        buttonDone.setBackground(new Color(0,0,0,0));
        buttonDone.setVisible(true);
        add(buttonDone);

        buttonCancel.setMargin(new Insets(0, 0, 0, 0));
        buttonCancel.setBorder(null);
        buttonCancel.setBounds(10,220,50,30);
        buttonCancel.setBackground(new Color(0,0,0,0));
        buttonCancel.setVisible(true);
        add(buttonCancel);




    }
}


package GUI_PHONE;




import CALCULATRICE.CALCULATRICE_APP;
import CONTACT.Contact;
import GALLERY.HOMEGALLERY;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class PHONE extends JFrame {

    //PANEL
    private JPanel header = new JPanel();
    private JPanel main = new JPanel();
    private JPanel footer = new JPanel();

    //IMAGES
    private ImageIcon homeButton = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\homeButton.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon iphone = (new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\iphone.jpg"));
    private ImageIcon wallpaper = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\Wallpaper.jpg").getImage().getScaledInstance(310, 525, Image.SCALE_DEFAULT));
    private ImageIcon contactButton = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\Contacts.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon eteindre = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\eteindre.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon calculateButton = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\calculatrice.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon galleryButton = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\gallery.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));



    //BUTTON
    private JButton buttonH = new JButton(homeButton);
    private JButton buttonC = new JButton(contactButton);
    private JButton buttonG = new JButton(galleryButton);
    private JButton buttonCalculatrice = new JButton(calculateButton);
    public JButton buttonEteindre = new JButton(eteindre);


    //LABEL
    private JLabel frameIphone = new JLabel(iphone);
    private JLabel fondEcran = new JLabel(wallpaper);

    //IMPLEMENTATION
    private CALCULATRICE_APP calculatrice_app = new CALCULATRICE_APP();
    private Contact contact = new Contact();
    private HOMEGALLERY homegallery = new HOMEGALLERY();

    HOME_SCREEN home_screen = new HOME_SCREEN(this,contact,calculatrice_app,homegallery, fondEcran, buttonC, buttonG, buttonCalculatrice, buttonEteindre);
    CLOCK timeLable = new CLOCK("time");







    public PHONE(){



        //a mettre partout
        setUndecorated(true);
        getContentPane().setBackground(new Color(0,0,0,0));


        setLayout(null);
        setBounds(86, 120, 310, 520);
        setBackground(Color.white);

        header.setBackground(Color.black);
        header.setBounds(86,89,310,30);
        header.setVisible(true);
        header.setLayout(null);
        header.add(timeLable);
        add(header);


        footer.setBackground(Color.white);
        footer.setBounds(86,650,310,55);
        footer.setVisible(true);
        footer.setLayout(null);
        add(footer);


        //Ajout du bouton Home avec image
        buttonH.setMargin(new Insets(0, 0, 0, 0));
        buttonH.setBorder(null);
        buttonH.setBounds(132,5,50,50);
        buttonH.setBackground(Color.white);
        buttonH.setVisible(true);
        buttonH.addActionListener(new ButtonListenerHome());
        footer.add(buttonH);

        add(homegallery);
        homegallery.setVisible(false);

        add(contact);
        contact.setVisible(false);

        add(calculatrice_app);
        calculatrice_app.setVisible(false);


        add(home_screen);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(480,800);

        //Pas de layout, on utilisera setBounds
        setLayout(null);

        //Enlever la fenêtre
        //setUndecorated(true);

        setLocationRelativeTo(null);

        //Impossible d'ajuster la taille de la fenêtre
        setResizable(false);

        // Ajout de l'image de l'iPhone qui va servir de fenêtre
        main.add(frameIphone);
        main.setSize(480,800);
        main.setVisible(true);
        add(main);


    }

    public class ButtonListenerHome implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            homegallery.setVisible(false);
            calculatrice_app.setVisible(false);
            contact.setVisible(false);

            home_screen.setVisible(true);

        }
    }

}
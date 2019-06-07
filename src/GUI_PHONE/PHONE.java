package GUI_PHONE;




import CALCULATRICE.CALCULATRICE_APP;
import CONTACT.Contact;
import GALLERY.HOMEGALLERY;


import javax.swing.*;
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

    private ImageIcon homeButton = new ImageIcon(new ImageIcon(getClass().getResource("/homeButton.jpg")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon iphone = (new ImageIcon(getClass().getResource("/iPhone3.jpeg")));
    private ImageIcon wallpaper = new ImageIcon(new ImageIcon(getClass().getResource("/Wallpaper.jpeg")).getImage().getScaledInstance(310, 525, Image.SCALE_DEFAULT));
    private ImageIcon contactButton = new ImageIcon(new ImageIcon(getClass().getResource("/Contacts.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon eteindre = new ImageIcon(new ImageIcon(getClass().getResource("/boutonEteindre.jpeg")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon calculateButton = new ImageIcon(new ImageIcon(getClass().getResource("/calculatrice.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon galleryButton = new ImageIcon(new ImageIcon(getClass().getResource("/gallery.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

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
    private Contact contact = new Contact("");
    private HOMEGALLERY homegallery = new HOMEGALLERY();

    HOME_SCREEN home_screen = new HOME_SCREEN(this,contact,calculatrice_app,homegallery, fondEcran, buttonC, buttonG, buttonCalculatrice, buttonEteindre);
    CLOCK timeLable = new CLOCK("time");





    public PHONE(){



        /**
         * Mise en forme de la frame
         */
        setUndecorated(true);
        setBackground(new Color(0,0,0,0));
        setLayout(null);
        setBounds(86, 120, 310, 520);

        /**
         * Ajout du JPanel en haut de l'écran qui accueillera l'heure du téléphone
         */
        header.setBackground(Color.black);
        header.setBounds(86,89,310,30);
        header.setVisible(true);
        header.setLayout(null);
        header.add(timeLable);
        add(header);


        /**
         * Mise en place du JPanel en bas de l'écran qui accueillera le boutonHome
         */
        footer.setBackground(Color.white);
        footer.setBounds(86,650,310,55);
        footer.setVisible(true);
        footer.setLayout(null);
        add(footer);


        /**
         * Ajout du bouton Home qui permettra de revenir sur l'écran principal (HOMESCREEN)
         */
        buttonH.setMargin(new Insets(0, 0, 0, 0));
        buttonH.setBorder(null);
        buttonH.setBounds(132,5,50,50);
        buttonH.setBackground(Color.white);
        buttonH.setVisible(true);
        buttonH.addActionListener(new ButtonListenerHome());
        footer.add(buttonH);

        /**
         * Ajout des application en setVisible pour qu'elles n'apparaissent que lorsqu'on clique dessus
         */
        add(homegallery);
        homegallery.setVisible(false);

        add(contact);
        contact.setVisible(false);

        add(calculatrice_app);
        calculatrice_app.setVisible(false);

        /**
         * Ajout de l'écran principal
         */
        add(home_screen);

        /**
         * Mise en forme de la frame
         */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480,800);
        setLocationRelativeTo(null);

        /**
         * Impossible d'ajuster la taille de la fenêtre
         */
        setResizable(false);

        /** Ajout du JPanel principal qui accueillera toute la frame
         *
         */
        main.add(frameIphone);
        main.setSize(480,800);
        main.setVisible(true);
        add(main);


    }

    /**
     * ActionListener permettant de revenir sur l'écran principal (HOMESCREEN)
     */
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
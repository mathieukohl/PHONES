package GUI_PHONE;




import CONTACT.CONTACT_APP;
import CONTACT.NEWCONTACT_APP;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PHONE extends JFrame {


    private JPanel header = new JPanel();
    private JPanel main = new JPanel();

    private ImageIcon homeButton = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\homeButton.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

    private ImageIcon iphone = (new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\iphone.jpg"));

    private JLabel frameIphone = new JLabel(iphone);

    NEWCONTACT_APP newcontact_app = new NEWCONTACT_APP();
    CONTACT_APP contact_app = new CONTACT_APP();
    HOME_SCREEN home_screen = new HOME_SCREEN();

    private JButton buttonH = new JButton(homeButton);

    CLOCK timeLable = new CLOCK("time");

    public PHONE(){


        header.setBackground(Color.black);
        header.setBounds(86,89,310,36);
        header.setVisible(true);
        header.setLayout(null);
        //.setBackground(new Color(0,0,0,0)); //a=0 = transparant
        header.add(timeLable);
        add(header);


        HOME_SCREEN home_screen = new HOME_SCREEN();
        home_screen.setVisible(true);
        home_screen.setBackground(Color.white);
        home_screen.setBounds(86,120,310,584);
        add(home_screen);



        //add(newcontact_app);
        //add(contact_app);


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

        buttonH.setMargin(new Insets(0, 0, 0, 0));
        buttonH.setBorder(null);
        buttonH.setBounds(218,651,50,50);
        buttonH.setBackground(new Color(0,0,0,0));
        buttonH.setVisible(true);
        add(buttonH);
    }


}
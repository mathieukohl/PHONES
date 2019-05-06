package GUI_PHONE;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PHONE extends JFrame {

    private JPanel header = new JPanel();
    private JPanel main = new JPanel();

    private ImageIcon iphone = (new ImageIcon("/Users/KohlMathieu/IdeaProjects/PHONES/src/IMAGES/iPhone3.jpeg"));

    private JLabel frameIphone = new JLabel(iphone);

    CLOCK timeLable = new CLOCK("time");

    public PHONE(){


        header.setBackground(Color.black);
        header.setBounds(86,89,310,36);
        header.setVisible(true);
        header.setLayout(null);
        header.add(timeLable);
        add(header);

        HOME_SCREEN home_screen = new HOME_SCREEN();
        home_screen.setVisible(true);
        home_screen.setBackground(Color.white);
        home_screen.setBounds(86,120,310,584);
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
}
package CONTACT;

import javax.swing.*;
import java.awt.*;

public class CONTACT_APP extends JPanel {

    private ImageIcon addButton = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\add.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));


    private JButton addContact = new JButton(addButton);

    private JList listContact = new JList();


    public CONTACT_APP() {

        setVisible(true);
        setLayout(null);
        setBackground(Color.white);
        setBounds(86,120,310,520);


        addContact.setMargin(new Insets(0, 0, 0, 0));
        addContact.setBorder(null);
        addContact.setBounds(270,20,25,25);
        addContact.setBackground(new Color(0,0,0,0)); //transparent
        addContact.setVisible(true);
        add(addContact);

        /*
        listContact.setBorder(null);
        listContact.setBounds(86,120,310,520);
        listContact.setBackground(new Color(250,250,250));
        listContact.setVisible(true);
        add(listContact); */
    }
}

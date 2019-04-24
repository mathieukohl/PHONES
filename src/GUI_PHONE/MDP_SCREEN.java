package GUI_PHONE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class MDP_SCREEN extends LOCK_SCREEN {

    private JPanel textPanel = new JPanel();
    private JPanel digitPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();

    private JTextField displayTextField = new JTextField(20);
       // private JButton sendButton = new JButton("Send");
       // private JButton clearButton = new JButton("Clear");
       // private JButton endButton = new JButton(" End ");
       // private JButton redialButton = new JButton("Redial");
        private JButton Button1 = new JButton("1");
        private JButton Button2 = new JButton("2");
        private JButton Button3 = new JButton("3");
        private JButton Button4 = new JButton("4");
        private JButton Button5 = new JButton("5");
        private JButton Button6 = new JButton("6");
        private JButton Button7 = new JButton("7");
        private JButton Button8 = new JButton("8");
        private JButton Button9 = new JButton("9");
        private JButton Button0 = new JButton("0");
        private JButton astrButton = new JButton("*");
        private JButton boundButton = new JButton("#");

    public MDP_SCREEN() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        buttonPanel.setLayout(new GridLayout(4,3));
        buttonPanel.add(Button1);
        buttonPanel.add(Button2);
        buttonPanel.add(Button3);
        buttonPanel.add(Button4);
        buttonPanel.add(Button5);
        buttonPanel.add(Button6);
        buttonPanel.add(Button7);
        buttonPanel.add(Button8);
        buttonPanel.add(Button9);
        buttonPanel.add(Button0);
        add(buttonPanel);


    }
}

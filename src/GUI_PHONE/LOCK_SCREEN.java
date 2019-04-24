package GUI_PHONE;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.*;

public class LOCK_SCREEN extends JFrame {



    ClockLabel timeLable = new ClockLabel("time");
    ClockLabel dateLable = new ClockLabel("date");


    private JLabel Enter = new JLabel("Slide to unlock");
    private JSlider Slider = new JSlider();
    private JPanel centerPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JButton push = new JButton("PUSH");

    public LOCK_SCREEN() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        centerPanel.setLayout(new GridLayout(2, 1));
        centerPanel.add(timeLable);
        centerPanel.add(dateLable);
        centerPanel.setVisible(true);
      //  centerPanel.setBackground(Color.black);
        add(centerPanel);


        bottomPanel.setLayout(new GridLayout(3,1));
        bottomPanel.add(Enter);
        bottomPanel.add(Slider);
        bottomPanel.add(push);
        //bottomPanel.setBackground(Color.black);
        add(bottomPanel, BorderLayout.SOUTH);


        pack();
    }

    class ClockLabel extends JLabel implements ActionListener {

        String type;
        SimpleDateFormat sdf;

        public ClockLabel(String type) {
            this.type = type;
            setForeground(Color.black);

            switch (type) {
                case "time":
                    sdf = new SimpleDateFormat("hh:mm:ss a");
                    setFont(new Font("sans-serif", Font.PLAIN, 40));
                    setHorizontalAlignment(SwingConstants.CENTER);
                    break;
                case "date":
                    sdf = new SimpleDateFormat("EEEE  MMMM dd, yyyy");
                    setFont(new Font("sans-serif", Font.PLAIN, 12));
                    setHorizontalAlignment(SwingConstants.CENTER);
                    break;
                default:
                    sdf = new SimpleDateFormat();
                    break;
            }

            Timer t = new Timer(1000, this);
            t.start();
        }


        public void actionPerformed(ActionEvent ae) {
            Date d = new Date();
            setText(sdf.format(d));


        }


    }
}

package GUI_PHONE;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class HOME_SCREEN extends JFrame {


    private JPanel header = new JPanel();
    private JPanel main = new JPanel();
    private JPanel footer = new JPanel();

    private ImageIcon headerbat = new ImageIcon("Macintosh HD/Users/KohlMathieu/Desktop/GUI PHONE/MMPHONE/IMAGE/sbLeft.png");
    private JLabel batterie = new JLabel(headerbat);

    ImageIcon i = new ImageIcon("Macintosh HD/Users/KohlMathieu/IdeaProjects/PHONES/src/GUI_PHONE/wallpaper.jpeg");
    JLabel wallpaper = new JLabel(i);

    private JButton home = new JButton();

    ClockLabel timeLable = new ClockLabel("time");



   public HOME_SCREEN() {
       setDefaultCloseOperation(EXIT_ON_CLOSE);




       header.setSize(480,30);
       header.setLayout(new GridLayout(1,3));
       header.add(timeLable);
       header.add(batterie);
       header.setBackground(Color.black);
       header.setVisible(true);
       add(header, BorderLayout.NORTH);

       main.add(wallpaper);
       main.setSize(480,670);
       main.setVisible(true);
       add(main);

       footer.setSize(480,100);
       footer.setVisible(true);
       footer.add(home);
       footer.setBackground(Color.black);
       add(footer, BorderLayout.SOUTH);
   }

       class ClockLabel extends JLabel implements ActionListener {

           String type;
           SimpleDateFormat sdf;

           public ClockLabel(String type) {
               this.type = type;
               setForeground(Color.white);

               switch (type) {
                   case "time":
                       sdf = new SimpleDateFormat("h:mm a");
                       setFont(new Font("sans-serif", Font.PLAIN, 10));
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



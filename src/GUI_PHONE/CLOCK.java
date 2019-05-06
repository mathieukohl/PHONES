package GUI_PHONE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CLOCK  extends JLabel implements ActionListener {

    String type;
    SimpleDateFormat sdf;

    public CLOCK(String type) {
        this.type = type;
        setForeground(Color.white);
        setBounds(130,-7,50,50);

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
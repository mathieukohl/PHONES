package CALCULATRICE;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class CALCULATRICE_APP extends JPanel {

    private JPanel container = new JPanel();
    //Tableau stockant les éléments à afficher dans la calculatrice
    String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
    //Un bouton par élément à afficher
    JButton[] tab_button = new JButton[tab_string.length];
    private JLabel ecran = new JLabel("");
    private Dimension dim = new Dimension(80, 80);
    private Dimension dim2 = new Dimension(50, 31);
    private double chiffre1;
    private boolean clicOperateur = false, update = false;
    private String operateur = "";
    Font police = new Font("Helvetica Neue", Font.BOLD, 25);

    private JPanel panEcran = new JPanel();
    private JPanel operateurPanel = new JPanel();
    private JPanel chiffre = new JPanel();

    private ImageIcon image = new ImageIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\HES-SO\\S2\\POO\\PHONES\\src\\IMAGES\\calcul.jpg").getImage().getScaledInstance(310, 135, Image.SCALE_DEFAULT));
    private JLabel imageFond = new JLabel(image);

    int x = 11;
    int y = 10;

    public CALCULATRICE_APP() {

        setVisible(true);
        setLayout(null);
        setBounds(86, 120, 310, 525);
        setBackground(Color.pink);

        ecran.setBounds(0, 10, 305, 75);
        ecran.setLayout(null);
        ecran.setVisible(true);
        ecran.setFont(police);
        ecran.setOpaque(false);
        ecran.setHorizontalAlignment(JLabel.RIGHT);

        panEcran.setVisible(true);
        panEcran.setLayout(null);
        panEcran.setBounds(0, 0, 310, 75);
        panEcran.setBackground(Color.white);
        panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
        panEcran.add(ecran);
        add(panEcran);

        chiffre.setVisible(true);
        chiffre.setLayout(null);
        chiffre.setBounds(0, 70, 225, 325);
        chiffre.setBackground(Color.red);
        chiffre.setBorder(BorderFactory.createLineBorder(Color.black));
        add(chiffre);

        operateurPanel.setVisible(true);
        operateurPanel.setLayout(null);
        operateurPanel.setBounds(225, 70, 85, 325);
        operateurPanel.setBackground(Color.green);
        operateurPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(operateurPanel);

        imageFond.setVisible(true);
        imageFond.setLayout(null);
        imageFond.setBounds(0, 340, 310, 235);
        imageFond.addMouseListener(new MouseListener() {
                                       @Override
                                       public void mouseClicked(MouseEvent e) {
                                           JOptionPane einstein = new JOptionPane();
                                           einstein.showMessageDialog(null,"E=MC2");

                                       }

                                       @Override
                                       public void mousePressed(MouseEvent e) {

                                       }

                                       @Override
                                       public void mouseReleased(MouseEvent e) {

                                       }

                                       @Override
                                       public void mouseEntered(MouseEvent e) {

                                       }

                                       @Override
                                       public void mouseExited(MouseEvent e) {

                                       }
                                   }
        )
        ;
        add(imageFond);

        for( int i = 0; i<tab_string.length; i++) {
            tab_button[i] = new JButton(tab_string[i]);
            tab_button[i].setBounds(x, y, 65, 65);
            chiffre.add(tab_button[i]);

            x += 70;
            if (i == 2 || i==5||i==8 ) {
                x = 11;
                y += 80;
            }

            switch (i) {
                //Pour chaque élément situé à la fin du tableau
                //et qui n'est pas un chiffre
                //on définit le comportement à avoir grâce à un listener
                case 11 :
                    tab_button[i].addActionListener(new EgalListener());
                    chiffre.add(tab_button[i]);
                    break;
                case 12:
                    tab_button[i].setForeground(Color.red);
                    tab_button[i].addActionListener(new ResetListener());
                    tab_button[i].setBounds(20, 20, 45, 45);
                    operateurPanel.add(tab_button[i]);
                    break;
                case 13:
                    tab_button[i].addActionListener(new PlusListener());
                    tab_button[i].setBounds(20, 80, 45, 45);
                    operateurPanel.add(tab_button[i]);
                    break;
                case 14:
                    tab_button[i].addActionListener(new MoinsListener());
                    tab_button[i].setBounds(20, 140, 45, 45);
                    operateurPanel.add(tab_button[i]);
                    break;
                case 15:
                    tab_button[i].addActionListener(new MultiListener());
                    tab_button[i].setBounds(20, 200, 45, 45);
                    operateurPanel.add(tab_button[i]);
                    break;
                case 16:
                    tab_button[i].addActionListener(new DivListener());
                    tab_button[i].setBounds(20, 260, 45, 45);
                    operateurPanel.add(tab_button[i]);
                    break;
                default:
                    //Par défaut, ce sont les premiers éléments du tableau
                    //donc des chiffres, on affecte alors le bon listener
                    chiffre.add(tab_button[i]);
                    tab_button[i].addActionListener(new ChiffreListener());
                    break;
            }
        }
    }
    //Méthode permettant d'effectuer un calcul selon l'opérateur sélectionné
    private void calcul(){
        if(operateur.equals("+")){
            chiffre1 = chiffre1 +
                    Double.valueOf(ecran.getText()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("-")){
            chiffre1 = chiffre1 -
                    Double.valueOf(ecran.getText()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("*")){
            chiffre1 = chiffre1 *
                    Double.valueOf(ecran.getText()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 /
                        Double.valueOf(ecran.getText()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            } catch(ArithmeticException e) {
                ecran.setText("0");
            }
        }
    }

    //Listener utilisé pour les chiffres
    //Permet de stocker les chiffres et de les afficher
    public class ChiffreListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //On affiche le chiffre additionnel dans le label
            String str = ((JButton)e.getSource()).getText();
            if(update){
                update = false;
            }
            else{
                if(!ecran.getText().equals("0"))
                    str = ecran.getText() + str;
            }
            ecran.setText(str);
        }
    }

    //Listener affecté au bouton =
    public class EgalListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            calcul();
            update = true;
            clicOperateur = false;
        }
    }

    //Listener affecté au bouton +
    public class PlusListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "+";
            update = true;
        }
    }

    //Listener affecté au bouton -
    public class MoinsListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "-";
            update = true;
        }
    }

    //Listener affecté au bouton *
    public class MultiListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "*";
            update = true;
        }
    }

    //Listener affecté au bouton /
    public class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "/";
            update = true;
        }
    }

    //Listener affecté au bouton de remise à zéro
    public class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            clicOperateur = false;
            update = true;
            chiffre1 = 0;
            operateur = "";
            ecran.setText("");
        }
    }

}
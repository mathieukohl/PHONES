package GALLERY;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HOMEGALLERY extends JPanel {

    private JPanel photoPanel = new JPanel();

    private JLabel galleriePhoto = new JLabel("Photos");

    private JLabel labelZoom = new JLabel();
    private JLabel labelZoomBouton = new JLabel();

    File path = new File("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images");

    // on a le chemin des images dans ce tableau ci-dessous
    File[] filesInFolder = path.listFiles();

    JPanel listeImages ;

    ImageIcon imageBack = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\backb.jpg").getImage().getScaledInstance(58, 50, Image.SCALE_DEFAULT));
    JButton backBouton = new JButton(imageBack);

    ImageIcon imageAdd = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\addb.jpg").getImage().getScaledInstance(58, 50, Image.SCALE_DEFAULT));
    JButton addBouton = new JButton(imageAdd);

    ImageIcon imageDelete = new ImageIcon(new ImageIcon("CC:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\deleteb.jpg").getImage().getScaledInstance(58, 50, Image.SCALE_DEFAULT));
    JButton deleteBouton = new JButton(imageDelete);

    JLabel imageLabel = new JLabel();
    File pathIconeZoomee;

    JScrollPane scrollPane = new JScrollPane();

    int x = 10;
    int y = 20;

    public HOMEGALLERY() {

        setVisible(true);
        setLayout(null);
        setBounds(0, 0, 310, 525);
        setBackground(Color.white);

        addBouton.setBounds(250,5,60,65);
        addBouton.setVisible(true);
        addBouton.setLayout(null);
        addBouton.setBackground(new Color(0,0,0,0));
        addBouton.setBackground(Color.white);
        addBouton.addActionListener(new ButtonListenerAdd());

        //Titre Photos
        galleriePhoto.setBounds(10,10, 200, 50);
        galleriePhoto.setLayout(null);
        galleriePhoto.setVisible(true);
        galleriePhoto.setFont(new Font("Helvetica Neue", Font.BOLD, 25));

        photoPanel.setVisible(true);
        photoPanel.setLayout(null);
        photoPanel.setBounds(0,0,310,70);
        photoPanel.setBackground(Color.white);
        photoPanel.add(galleriePhoto);
        photoPanel.add(addBouton);
        add(photoPanel);

        listeImages = createJPanelGallery(path);
        add(listeImages);

        // JScroll
        scrollPane.setViewportView(listeImages);
        JScrollBar jScrollBar = new JScrollBar();
        scrollPane.add(jScrollBar);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 70, 310,455);
        add(scrollPane);
        scrollPane.repaint();
        scrollPane.revalidate();


    }

    public JPanel createJPanelGallery(File folder){

        JPanel panelImages = new JPanel();
        panelImages.removeAll();
        panelImages.setVisible(true);
        panelImages.setLayout(null);
        panelImages.setBackground(Color.white);
        panelImages.setPreferredSize(new Dimension(310,20+(filesInFolder.length/2)*150+150));
        panelImages.setBounds(0, 50, 310,20+(filesInFolder.length/2)*150+150);

        // on a le chemin des images dans ce tableau ci-dessous
        filesInFolder = folder.listFiles();

        JButton[] image = new JButton[filesInFolder.length];

        for (int i = 0; i < filesInFolder.length; i++) {
            ImageIcon icone = new ImageIcon(new ImageIcon(String.valueOf(filesInFolder[i])).getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT));
            image[i] = new JButton(icone);
            image[i].setBorder(null);
            image[i].setVisible(true);
            image[i].setBackground(Color.white);
            image[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            image[i].setBounds(x, y, 125, 125);
            image[i].addActionListener(new ButtonListenerZoom(String.valueOf(filesInFolder[i])));

            panelImages.add(image[i]);

            x += 140;

            if (i % 2 == 1) {
                x = 10;
                y += 150;
            }

        }


        //panelImages.setVisible(true);
        return panelImages;


    }

    public class ButtonListenerZoom implements ActionListener {

        private String pathIcon;

        public ButtonListenerZoom(String pathIcon){
            this.pathIcon = pathIcon;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            scrollPane.setVisible(false);
            //galleriePhoto.setVisible(false);
            photoPanel.setVisible(false);
            listeImages.setVisible(false);

            ImageIcon icone = new ImageIcon(new ImageIcon(pathIcon).getImage().getScaledInstance(310,464,Image.SCALE_DEFAULT));

            pathIconeZoomee = new File(pathIcon);
            System.out.println(pathIcon);
            imageLabel = new JLabel(icone);
            imageLabel.setLayout(null);
            imageLabel.setVisible(true);
            imageLabel.setBounds(0, 60, 310, 465);

            backBouton.setBounds(0, 0, 155, 60);
            backBouton.setVisible(true);
            backBouton.setLayout(null);
            backBouton.setBackground(Color.LIGHT_GRAY);
            backBouton.addActionListener(new ButtonListenerBack());

            deleteBouton.setBounds(155, 0, 155, 60);
            deleteBouton.setVisible(true);
            deleteBouton.setLayout(null);
            deleteBouton.setBackground(Color.LIGHT_GRAY);
            deleteBouton.addActionListener(new ButtonListenerDelete());

            labelZoomBouton.add(backBouton);
            labelZoomBouton.add(deleteBouton);
            labelZoomBouton.setLayout(null);
            labelZoomBouton.setBounds(0, 0, 310, 60);
            labelZoomBouton.setVisible(true);

            labelZoom.add(imageLabel);
            labelZoom.setLayout(null);
            labelZoom.setBounds(0, 0, 310, 550);
            labelZoom.setVisible(true);

            add(labelZoom);
            add(labelZoomBouton);

        }
    }

    public class ButtonListenerBack implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            labelZoom.setVisible(false);
            labelZoomBouton.setVisible(false);
            imageLabel.setVisible(false);
            photoPanel.setVisible(true);
            scrollPane.setVisible(true);
            listeImages.setVisible(true);

           /* listeImages.removeAll();
            listeImages = createJPanelGallery(path);
            add(listeImages);*/


        }
    }

    public class ButtonListenerDelete implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            labelZoom.setVisible(false);
            imageLabel.setVisible(false);

            File file = new File(String.valueOf(pathIconeZoomee));

            System.out.println(pathIconeZoomee);
            boolean b = file.delete();
            System.out.println(b);

        }
    }

    public class ButtonListenerAdd implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();

                String image = path+"\\"+selectedFile.getName();

                Path source= Paths.get(String.valueOf(fileChooser.getSelectedFile()));
                Path destination = Paths.get(image);

                try {
                    Files.copy(source,destination);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }



        }
    }
}

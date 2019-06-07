package GALLERY;


import CONTACT.Contact;

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

    /**
     * Chemin dans lequel on va chercher les photos qu'on a besoin pour la gallerie photo
     */
    File path = new File("./ALBUM");
    //File test = new File(getClass().getResource("/attackdestitans.png").getFile());


    /** on a le chemin des images dans ce tableau ci-dessous
     *
     */
    File[] filesInFolder = path.listFiles();


    /**
     * JPanel qui sera utilisé avec la méthode createJPanelGallery
     */
    JPanel listeImages ;

    /**
     * Ajout d'une image Back aux bonnes dimensions et implémentation de cette image dans 2 JButton
     */
    ImageIcon imageBack = new ImageIcon(new ImageIcon(getClass().getResource("/backb.jpg")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    JButton backBouton = new JButton(imageBack);
    JButton backBouton2 = new JButton(imageBack);

    /**
     * Ajout d'une image Add aux bonnes dimensions et implémentation de cette image dans 2 JButton
     */
    ImageIcon imageAdd = new ImageIcon(new ImageIcon(getClass().getResource("/addb.jpg")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    JButton addBouton = new JButton(imageAdd);
    JButton addBouton2 = new JButton(imageAdd);

    /**
     * Ajout d'une image Delete aux bonnes dimensions et implémentation de cette image dans 1 JButton
     */
    ImageIcon imageDelete = new ImageIcon(new ImageIcon(getClass().getResource("/deleteb.jpg")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    JButton deleteBouton = new JButton(imageDelete);

    /**
     * Création d'un JLabel qui deviendra la photo zoomée
     */
    JLabel imageLabel = new JLabel();

    /**
     * Variable File qui va permettre de stocker le chemin de l'image sur laquelle on a zoomé
     */
    File pathIconeZoomee;

    /**
     * Création du JScrollPane et du JScrollBar pour la liste des photos
     */
    JScrollPane scrollPane = new JScrollPane();
    JScrollBar jScrollBar = new JScrollBar();

    private Contact contact;


    public HOMEGALLERY() {
        /**
         * Mets en forme la classe HOMEGALLERY
         */
        setVisible(true);
        setLayout(null);
        setBounds(86, 120, 310, 525);
        setBackground(Color.white);


        /**
         * Ajout du bouton Ajout de photos
         */
        addBouton.setBounds(250,5,60,65);
        addBouton.setVisible(true);
        addBouton.setLayout(null);
        addBouton.setBackground(new Color(0,0,0,0));
        addBouton.setBackground(Color.white);
        addBouton.addActionListener(new ButtonListenerAdd());

        /**Mets en forme le JLabel ou le titre "Photo" va apparaître
         *
         */
        galleriePhoto.setBounds(10,10, 200, 50);
        galleriePhoto.setLayout(null);
        galleriePhoto.setVisible(true);
        galleriePhoto.setFont(new Font("Helvetica Neue", Font.BOLD, 25));

        /**Mets en forme le JPanel qui accueille le JLabel galleriePhoto
         *
         */
        photoPanel.setVisible(true);
        photoPanel.setLayout(null);
        photoPanel.setBounds(0,0,310,70);
        photoPanel.setBackground(Color.white);
        photoPanel.add(galleriePhoto);
        photoPanel.add(addBouton);
        add(photoPanel);

        /**Création du JPanel ou se trouveront toutes les images
         *
         */
        listeImages = createJPanelGallery(path);
        add(listeImages);

        /**Ajout du JScrollPane permettant de descendre dans la gallerie photo
         *
         */
        scrollPane.setViewportView(listeImages);
        scrollPane.add(jScrollBar);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 70, 310,455);
        add(scrollPane);
        scrollPane.repaint();
        scrollPane.revalidate();


    }


    /**
     * Deuxième constructeur HOMEGALLERY utilisée lorsqu'on veut ajouter une photo à contact depuis l'application Contact. Ce constructeur est similaire au premier mais le boutons back a été supprimé.
     * Il faut terminer l'opération d'ajouter une photo à un contact pour revenir sous le contact en question.
     * Lorsque l'on zoom sur une photo, un bouton back a été ajouté pour revoir la gallerie en entier et un bouton add a été ajouté pour ajouter la photo au contact
     * @param contact
     */
    public HOMEGALLERY(Contact contact){
        /**
         * Mets en forme la classe HOMEGALLERY
         */
        setVisible(true);
        setLayout(null);
        setBounds(86, 120, 310, 525);
        setBackground(Color.white);

        /**Mets en forme le JLabel ou le titre "Photo" va apparaître
         *
         */
        galleriePhoto.setBounds(10,10, 200, 50);
        galleriePhoto.setLayout(null);
        galleriePhoto.setVisible(true);
        galleriePhoto.setFont(new Font("Helvetica Neue", Font.BOLD, 25));

        /**Mets en forme le JPanel qui accueille le JLabel galleriePhoto
         *
         */
        photoPanel.setVisible(true);
        photoPanel.setLayout(null);
        photoPanel.setBounds(0,0,310,70);
        photoPanel.setBackground(Color.white);
        photoPanel.add(galleriePhoto);
        add(photoPanel);

        /**Création du JPanel ou se trouveront toutes les images
         *
         */
        listeImages = createJPanelGalleryContact(path);
        add(listeImages);

        /**Ajout du JScrollPane permettant de descendre dans la gallerie photo
         *
         */
        scrollPane.setViewportView(listeImages);
        scrollPane.add(jScrollBar);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 70, 310,455);
        add(scrollPane);
        scrollPane.repaint();
        scrollPane.revalidate();
    }

    /**Méthode permettant de crée le JPanel ou toutes les photos de la gallerie vont s'afficher lorsqu'on clique sur l'application Gallerie photo
     *Cette méthode ajoute les photos dans un tableau de JButton et les ajoute a un JPanel
     *Ce JPanel est retourné
     * @param folder
     * @return
     */
    public JPanel createJPanelGallery(File folder){

        // on a le chemin des images dans ce tableau ci-dessous
        filesInFolder = folder.listFiles();

        int x = 10;
        int y = 20;

        JPanel panelImages = new JPanel();
        panelImages.setVisible(true);
        panelImages.setLayout(null);
        panelImages.setBackground(Color.white);
        panelImages.setPreferredSize(new Dimension(310,20+(filesInFolder.length/2)*150+150));
        panelImages.setBounds(0, 50, 310,20+(filesInFolder.length/2)*150+150);


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


        return panelImages;


    }

    /**Méthode permettant de crée le JPanel avec toutes les photos existantes mais lorsque l'on veut ajouter une photo à un contact
     *Cette méthode ajoute les photos dans un tableau de JButton et les ajoute a un JPanel
     * Ce JPanel est retourné
     * @param folder
     * @return
     */
    public JPanel createJPanelGalleryContact(File folder){

        // on a le chemin des images dans ce tableau ci-dessous
        filesInFolder = folder.listFiles();

        int x = 10;
        int y = 20;

        JPanel panelImages = new JPanel();
        panelImages.setVisible(true);
        panelImages.setLayout(null);
        panelImages.setBackground(Color.white);
        panelImages.setPreferredSize(new Dimension(310,20+(filesInFolder.length/2)*150+150));
        panelImages.setBounds(0, 50, 310,20+(filesInFolder.length/2)*150+150);


        JButton[] image = new JButton[filesInFolder.length];


        for (int i = 0; i < filesInFolder.length; i++) {
            ImageIcon icone = new ImageIcon(new ImageIcon(String.valueOf(filesInFolder[i])).getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT));
            image[i] = new JButton(icone);
            image[i].setBorder(null);
            image[i].setVisible(true);
            image[i].setBackground(Color.white);
            image[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            image[i].setBounds(x, y, 125, 125);
            image[i].addActionListener(new ButtonListenerZoomContact(String.valueOf(filesInFolder[i])));

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

    /**ActionListener permettant de zoomer sur une photo lorsque nous voulons ajouter une photo à un contact depuis l'application Contact
     */
    public class ButtonListenerZoomContact implements ActionListener {

        private String pathIcon;

        public ButtonListenerZoomContact(String pathIcon){
            this.pathIcon = pathIcon;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            scrollPane.setVisible(false);
            photoPanel.setVisible(false);
            listeImages.setVisible(false);

            ImageIcon icone = new ImageIcon(new ImageIcon(pathIcon).getImage().getScaledInstance(310,464,Image.SCALE_DEFAULT));

            pathIconeZoomee = new File(pathIcon);
            System.out.println(pathIcon);
            imageLabel = new JLabel(icone);
            imageLabel.setLayout(null);
            imageLabel.setVisible(true);
            imageLabel.setBounds(0, 60, 310, 465);

            backBouton2.setBounds(0, 0, 155, 60);
            backBouton2.setVisible(true);
            backBouton2.setLayout(null);
            backBouton2.setBackground(Color.LIGHT_GRAY);
            backBouton2.addActionListener(new ButtonListenerBackContact());

            addBouton2.setBounds(155, 0, 155, 60);
            addBouton2.setVisible(true);
            addBouton2.setLayout(null);
            addBouton2.setBackground(Color.LIGHT_GRAY);
            addBouton2.addActionListener(new ButtonListenerAddPhotoToContact());

            labelZoomBouton.add(backBouton2);
            labelZoomBouton.add(addBouton2);
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


    //ActionListener permettant de zoomer sur une photo choisie
    public class ButtonListenerZoom implements ActionListener {

        private String pathIcon;

        public ButtonListenerZoom(String pathIcon){
            this.pathIcon = pathIcon;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            scrollPane.setVisible(false);
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

    /**
     * ActionListener permettant de revenir à la gallerie photo après avoir zoomer sur une photo
     */
    public class ButtonListenerBack implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            labelZoom.setVisible(false);
            labelZoomBouton.setVisible(false);
            imageLabel.setVisible(false);
            photoPanel.setVisible(true);
            scrollPane.setVisible(true);
            listeImages.setVisible(true);


            listeImages = createJPanelGallery(path);
            add(listeImages);

            scrollPane.setViewportView(listeImages);
            scrollPane.add(jScrollBar);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setBounds(0, 70, 310,455);
            add(scrollPane);
            scrollPane.repaint();
            scrollPane.revalidate();


        }
    }

    /**ActionListener utilisée pour le 2ème constructeur HOMEGALLERY(Contact contact) pour faire revenir sous la gallerie photo de ce même constructeur
     *
     */
    public class ButtonListenerBackContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            labelZoom.setVisible(false);
            labelZoomBouton.setVisible(false);
            imageLabel.setVisible(false);
            photoPanel.setVisible(true);
            scrollPane.setVisible(true);
            listeImages.setVisible(true);


            listeImages = createJPanelGalleryContact(path);
            add(listeImages);

            scrollPane.setViewportView(listeImages);
            scrollPane.add(jScrollBar);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setBounds(0, 70, 310,455);
            add(scrollPane);
            scrollPane.repaint();
            scrollPane.revalidate();

        }
    }

    /**ActionListener permettant d'ajouter une photo à un contact avec le 2ème constructeur de HOMEGALLERY (HOMEGALLERY (Contact contact))
     *Nous arrivons juste à trouver le lien de l'image à ajouter mais nous n'avons pas réussi à l'ajouter au contact et à revenir sous le contact adéquat avec l'image qui s'affiche
     */
    public class ButtonListenerAddPhotoToContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JOptionPane addPhoto = new JOptionPane();
            int option = addPhoto.showConfirmDialog(null, "Voulez-vous ajouter cette photo à votre contact ?",
                    "Ajout de photo au contact", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == 0){
                System.out.println("testJOPTIONPANEOui");
                //contact.setPicture(pathIconeZoomee.getPath());
                //contact.getPicture();
                //add(contact);
                // contact.setVisible(true);
                //setComponentZOrder(contact,0);
            }
        }
    }

    /**ActionListener permettant la suppression d'une image
     *
     */
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

    /**ActionListener permettant l'ajout d'une image
     *
     */
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

                listeImages = createJPanelGallery(path);
                add(listeImages);

                scrollPane.setViewportView(listeImages);
                scrollPane.add(jScrollBar);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.setBounds(0, 70, 310,455);
                add(scrollPane);
                scrollPane.repaint();
                scrollPane.revalidate();
            }
        }
    }
}
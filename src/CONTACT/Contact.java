package CONTACT;

import GALLERY.HOMEGALLERY;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Contact extends JPanel implements ActionListener {




    /**
     *
     * fileContact is the file in which the list of contacts is saved
     *
     **/

    //FILE TO FIND SAVED CONTACT
    private static String fileContact = "C:\\\\Users\\\\mathi\\\\IdeaProjects\\\\PHONES\\\\src\\\\contact.txt";

    /**
     * IMAGES LINKS
     **/
    private  ImageIcon addphoto = new ImageIcon(new ImageIcon(getClass().getResource("/addb.jpg")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    //private ImageIcon deleteContact = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\deleteb.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    // private ImageIcon backContact = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\backb.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));


    /**
     * FONT ORGANIZER
     **/

    Font fontL = new Font("Arial", Font.BOLD, 16);
    Font fontTF = new Font("Arial", Font.ITALIC, 16);
    Font fontButton = new Font("Arial", Font.BOLD, 14);
    Font title = new Font("Arial", Font.BOLD, 22);


    /**
     * TEXT FOR BUTTON
     **/
    static String contactTitle = "CONTACT";
    static String addButtonT = "+";
    static String modifyButtonT = "EDIT";
    static String saveButtonT = "SAVE";
    static String updateButtonT = "SAVE UPDATE";
    static String cancelButtonT = "CANCEL";
    static String deleteButtonT = "DELETE";
    static String backButtonT = "BACK";
    static String yesButtonT = "YES";
    static String noButtonT = "NO";

    /**
     * BUTTON
     **/

    private static JButton addButton = new JButton(addButtonT);
    private static JButton editButton	= new JButton(modifyButtonT);
    private static JButton saveButton = new JButton(saveButtonT);
    private static JButton updateButton = new JButton(updateButtonT);
    private static JButton deleteButton = new JButton(deleteButtonT);
    private static JButton cancelButton	= new JButton(cancelButtonT);
    private static JButton backButton = new JButton(backButtonT);
    private  JButton addPhotoButton = new JButton(addphoto);

    /**
     * BUTTON TEST NEVER USED
     **/

    private static JButton yesButton = new JButton(yesButtonT);
    private static JButton noButton = new JButton(noButtonT);



    /**
     * TEXT LABEL
     **/

    static String nameLabelT = "Nom";
    static String firstnameLabelT = "Prenom";
    static String phoneLabelT = "Numero de telephone";
    static String emailLabelT = "Email";
    static String addressLabelT = "Adresse";
    static String zipcityLabelT = "CP / Ville";
    static String addPhotolT = "Photo";

    /**
     * LABELS
     **/
    private JLabel contactLb = new JLabel(contactTitle);
    private JLabel nameLb = new JLabel(nameLabelT);
    private JLabel firstnameLb = new JLabel(firstnameLabelT);
    private JLabel numLb = new JLabel(phoneLabelT);
    private JLabel emailLb = new JLabel(emailLabelT);
    private JLabel addressLb = new JLabel(addressLabelT);
    private JLabel ZIPLb = new JLabel(zipcityLabelT);
    private JLabel addPhotoLb = new JLabel(addPhotolT);
    private JLabel picture = new JLabel();

    private static JLabel image = new JLabel();



    /**
     * ERROR MESSAGES
     **/
    static String errorDeleteT = "Un probleme est survenu lors de la suppression.";
    static String errorModifyT = "Une erreur est survenue lors de la modification. Veuillez corriger.";
    static String errorWriteT = "Erreur lors de l'écriture dans le fichier.";
    static String errorUpdateT = "Erreur lors de la modification.";
    static String errorReadT = "Erreur de lecteur.";

    /**
     * STRING WHEN YOU DELETE A CONTACT
     **/
    static String deletedField = "#valeurSupprimee";


    /**
     * ADD VALIDATOR TO USE THE METHODES VALIDATE
     **/
    Validator validator = new Validator();



    /**
     * DIMENSION FOR LABEL & TEXTFIELD
     **/
    private Dimension dimension = new Dimension(480, 30);

    /**
     * PANELS
     **/
    private JPanel scrollPanePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private static JPanel labelTfPanel = new JPanel();
    private static JPanel imagePanel = new JPanel();
    private JPanel formPanel = new JPanel();
    private static JPanel fondEcran = new JPanel();
    private JPanel suppMessage = new JPanel();

    /**
     * LIST
     **/
    protected static JList contactL = new JList(); //List which contains the data


    /**
     * TEXTFIELD
     **/
    private static JTextField nameTf = new JTextField();
    private static JTextField firstnameTf = new JTextField();
    private static JTextField numTf = new JTextField();
    private static JTextField emailTf = new JTextField();
    private static JTextField adressTf = new JTextField();
    private static JTextField ZIPTf = new JTextField();


    /**
     * TABS
     **/
    private static String[] contactList;
    private static String[] contactArray;
    private static ContactData[] contactData;

    /**
     * IMPLEMENTS OTHERS CLASSES
     **/
    private HOMEGALLERY homegallery;
    private Contact contact;

    public Contact(String s) {

        this.contact = this;

        /**
         * SCROLL BAR
         **/
        JScrollPane scrollPane = new JScrollPane(contactL);


        scrollPanePanel.setLayout(new BorderLayout());
        formPanel.setLayout(new BorderLayout());


        scrollPanePanel.add(scrollPane,BorderLayout.CENTER);


        formPanel.add(buttonPanel,BorderLayout.SOUTH);
        formPanel.add(labelTfPanel,BorderLayout.CENTER);
        formPanel.add(imagePanel,BorderLayout.NORTH);

        //PANEL OF BUTTONS
        //buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);
        //buttonPanel.add(addPhotoButton);
        // buttonPanel.add(yesButton);
        //buttonPanel.add(noButton);

        image.setIcon(addphoto);

        /**
         * LABELS OF TEXTFIELDS
         **/
        labelTfPanel.setLayout(new GridLayout(18, 1));
        labelTfPanel.add(nameLb);
        labelTfPanel.add(nameTf);
        labelTfPanel.add(firstnameLb);
        labelTfPanel.add(firstnameTf);
        labelTfPanel.add(numLb);
        labelTfPanel.add(numTf);
        labelTfPanel.add(emailLb);
        labelTfPanel.add(emailTf);
        labelTfPanel.add(addressLb);
        labelTfPanel.add(adressTf);
        labelTfPanel.add(ZIPLb);
        labelTfPanel.add(ZIPTf);
        //labelTfPanel.add(addPhotoLb);
        //labelTfPanel.add(image);
        imagePanel.add(addPhotoButton);




        /**
         * ADDING PANNELS
         **/
        add(scrollPanePanel,BorderLayout.NORTH); //CONTACT LIST
        add(formPanel,BorderLayout.SOUTH); //CONTACT WITH DATA

        /**
         * HIDE TEXTFIELD LABEL
         **/
        labelTfPanel.setVisible(false);
        imagePanel.setVisible(false);

        /**
         * HIDE BUTTONS
         **/
        editButton.setVisible(false);
        saveButton.setVisible(false);
        cancelButton.setVisible(false);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
        backButton.setVisible(false);
        addPhotoButton.setVisible(false);

        /**
         * ACTION LISTENER FOR THE BUTTONS
         **/
        addButton.addActionListener(new AddContact());
        editButton.addActionListener(new EditContact());
        saveButton.addActionListener(new ValidateNewContact());
        cancelButton.addActionListener(new CancelContact());
        updateButton.addActionListener(new ValidateExistingContact());
        deleteButton.addActionListener(new DeleteContact());
        backButton.addActionListener(new BackContact());
        addPhotoButton.addActionListener(new AddPhoto());
        //yesButton.addActionListener(new YesSup());
        //noButton.addActionListener(new NoSup());



        /**
         * SELECT LISTENER TO SHOW CONTACT WHEN YOU CLIC ON IT
         **/
        contactL.addListSelectionListener(new LSListener());



        /**
         * SET SIZE OF DIFFERENT PANEL
         **/
        this.setLayout(null);
        this.scrollPanePanel.setBounds(0, 100, 310, 350); //SIZE OF CONTACT LIST
        this.formPanel.setBounds(0, 50, 310, 430); // SIZE OF CONTACT'S DATA


        contactStyle();
    }

    /**
     * POSTIONING AND STYLING THE APP CONTACT TO HAVE THE LIST, BUTTONS... HOW WE WANT
     **/

    public JLabel getPicture() {
        System.out.println(picture.getText());
        return picture;
    }

    public void setPicture(String picture) {
        this.picture.setText(picture);
    }

    public void contactStyle(){


        setLayout(null);
        setBackground(Color.green);
        setBounds(86, 120, 310, 525);


        //ADD FONDECRAN ON THE FRAME
        fondEcran.setBounds(0, 0, 310, 525);
        fondEcran.setVisible(true);
        //fondEcran.setBackground(Color.blue);
        fondEcran.setLayout(null);
        add(fondEcran);


        contactLb.setBounds(10,5,150,30);
        contactLb.setVisible(true);
        contactLb.setLayout(null);
        contactLb.setFont(title);
        fondEcran.add(contactLb);


        addButton.setBounds(250, 5, 50, 30);
        addButton.setVisible(true);
        addButton.setLayout(null);
        fondEcran.add(addButton);

        //TEST TO ADD THE DELETE MESSAGE TO A NEW PANEL
        suppMessage.setBounds(0,0,310,525);
        suppMessage.setVisible(false);
        suppMessage.setLayout(null);
        add(fondEcran);


        //NAME
        nameLb.setFont(fontL);
        nameLb.setPreferredSize(dimension);
        nameLb.setOpaque(true);
        nameTf.setFont(fontTF);
        nameTf.setBorder(null);
        nameTf.setBackground(Color.white);
        nameTf.setPreferredSize(dimension);


        //FIRSTNAME

        firstnameLb.setFont(fontL);
        firstnameLb.setPreferredSize(dimension);
        firstnameLb.setOpaque(true);
        firstnameTf.setFont(fontTF);
        firstnameTf.setBorder(null);
        firstnameTf.setBackground(Color.white);
        firstnameTf.setPreferredSize(dimension);


        //NUM
        numLb.setFont(fontL);
        numLb.setPreferredSize(dimension);
        numLb.setOpaque(true);
        numTf.setFont(fontTF);
        numTf.setBorder(null);
        numTf.setBackground(Color.white);
        numTf.setPreferredSize(dimension);

        //MAIL

        emailLb.setFont(fontL);
        emailLb.setPreferredSize(dimension);
        emailLb.setOpaque(true);
        emailTf.setFont(fontTF);
        emailTf.setBorder(null);
        emailTf.setBackground(Color.white);
        emailTf.setPreferredSize(dimension);

        //ADRESS
        addressLb.setFont(fontL);
        addressLb.setPreferredSize(dimension);
        addressLb.setOpaque(true);
        adressTf.setFont(fontTF);
        adressTf.setBorder(null);
        adressTf.setBackground(Color.white);
        adressTf.setPreferredSize(dimension);

        //ZIP
        ZIPLb.setFont(fontL);
        ZIPLb.setPreferredSize(dimension);
        ZIPLb.setOpaque(true);
        ZIPTf.setBorder(null);
        ZIPTf.setBackground(Color.white);
        ZIPTf.setFont(fontTF);
        //ZIPTf.setBounds(10,340,280,30);
        ZIPTf.setPreferredSize(dimension);

        addPhotoLb.setFont(fontL);
        addPhotoLb.setPreferredSize(dimension);
        addPhotoLb.setOpaque(true);
        addPhotoButton.setBackground(new Color(0,0,0,0));
        addPhotoButton.setMargin(new Insets(0, 0, 0, 0));


        // FONT EDIT FOR BUTTON
        addButton.setFont(fontButton);
        editButton.setFont(fontButton);
        saveButton.setFont(fontButton);
        cancelButton.setFont(fontButton);
        updateButton.setFont(fontButton);
        deleteButton.setFont(fontButton);
        backButton.setFont(fontButton);
        //addPhotoButton.setFont(fontButton);



    }

    /**
     * WHAT HAPPEN WHEN YOU CLIC ON ADD CONTACT
     * SHOW AND HIDE DIFFERENT PANELS AND BUTTONS
     **/
    class AddContact implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            contactL.setEnabled(false);
            setFieldsToNULL();
            scrollPanePanel.setVisible(false);
            formPanel.setVisible(true);
            labelTfPanel.setVisible(true);
            imagePanel.setVisible(true);
            cancelButton.setVisible(true);
            saveButton.setVisible(true);
            addButton.setVisible(false);
            editButton.setVisible(false);
            deleteButton.setVisible(false);
            updateButton.setVisible(false);
            contactLb.setVisible(false);
            addButton.setVisible(false);
            addPhotoButton.setVisible(true);
            setEditable(true);
        }
    }

    /**
     * WHAT HAPPEN WHEN YOU CLIC ON EDIT CONTACT
     * SHOW AND HIDE DIFFERENT PANELS AND BUTTONS
     **/
    class EditContact implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int numJList = contactL.getSelectedIndex();
            if(numJList == -1){
                return;
            }
            cancelButton.setVisible(true);
            updateButton.setVisible(true);
            contactL.setEnabled(false);
            addButton.setVisible(false);
            editButton.setVisible(false);
            deleteButton.setVisible(false);
            saveButton.setVisible(false);
            contactLb.setVisible(false);
            setEditable(true);
            labelTfPanel.setVisible(true);
            imagePanel.setVisible(true);
            backButton.setVisible(false);
        }
    }


    /**
     * SELECT LISTENER TO SHOW CONTACT WHEN YOU CLIC ON IT
     * SHOW AND HIDE DIFFERENT PANELS AND BUTTONS
     **/
    class LSListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent evt){
            int i = contactL.getSelectedIndex();
            labelTfPanel.setVisible(true); // Show contact form
            imagePanel.setVisible(true);
            setEditable(false);
            editButton.setVisible(true);
            deleteButton.setVisible(true);
            backButton.setVisible(true);
            scrollPanePanel.setVisible(false);
            formPanel.setVisible(true);
            contactLb.setVisible(false);
            addButton.setVisible(false);

            if(i != -1){
                nameTf.setText(contactData[i].getName());
                firstnameTf.setText(contactData[i].getFirstname());
                numTf.setText(contactData[i].getPhone());
                emailTf.setText(contactData[i].getEmail());
                adressTf.setText(contactData[i].getAddress());
                ZIPTf.setText(contactData[i].getZipcity());
            }
        }
    }

    /**
     * CONTROL IF THE INFOS THE USER WRITE ARE IN A CORRECT FORM AND IF NOT, SHOW HIM WITH PUTTING IN RED HIS TEXT
     **/

    class ValidateNewContact implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(validEmail(emailTf.getText())){
                emailTf.setForeground(Color.BLACK);
                if(validPhone(numTf.getText())) {
                    numTf.setForeground(Color.BLACK);
                    addToStream();
                    setFieldsToNULL();
                    showDefault();
                    scrollPanePanel.setVisible(true);

                } else {
                    numTf.setForeground(Color.RED);
                }
            } else {
                emailTf.setForeground(Color.RED);
            }
        }
    }

    /**
     * WHAT HAPPEN WHEN YOU CLIC ON THE BUTTON CONTACT
     * SHOW AND HIDE DIFFERENT PANELS AND BUTTONS
     **/
    class CancelContact implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                contactL.clearSelection();
                labelTfPanel.setVisible(false);
                imagePanel.setVisible(false);
                scrollPanePanel.setVisible(true);
                backButton.setVisible(false);
                contactLb.setVisible(true);
                showDefault(); // Set the buttons back to their initial state
                setFieldsToNULL(); // Deleting the content in the JTextFields
            } catch (Exception ex){
                System.out.println(errorDeleteT);
                System.out.println(ex.toString());
            }
        }
    }

    /**
     * WHAT HAPPEN WHEN YOU CLIC ON BACK BUTTON
     * RETURN TO THE PREVIEWS PANEL
     * SHOW AND HIDE DIFFERENT PANELS AND BUTTONS
     **/
    class BackContact implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //contactL.clearSelection(); // Clearing the contactLF
                scrollPanePanel.setVisible(true);
                labelTfPanel.setVisible(false); // Hiding labelTfPanel
                imagePanel.setVisible(false);
                backButton.setVisible(false);
                contactLb.setVisible(true);
                showDefault(); // Set the buttons back to their initial state
                setFieldsToNULL(); // Deleting the content in the JTextFields
            } catch (Exception ex){
                System.out.println(errorDeleteT);
                System.out.println(ex.toString());
            }
        }
    }


    /**
     * READ THE DATA ON THE TXT FILE
     **/
    public void readContact() {
        String ligne;
        try {
            int buffLength = 0;
            BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileContact)));
            while ((buff.readLine()) != null) {
                buffLength++;
            }
            contactArray = new String[buffLength];
            buff.close();
        } catch (Exception e) {
            System.out.println(errorReadT);
            System.out.println(e.toString());
        }

        try {
            int buffLength = 0;
            BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileContact)));
            while ((ligne = buff.readLine()) != null) {
                contactArray[buffLength] = ligne;
                buffLength++;
            }
            buff.close();
            updateList();
            contactL.setEnabled(true);
        } catch (Exception e) {
            System.out.println(errorReadT);
            System.out.println(e.toString());
        }
    }

    /**
     *  ADD DATA ON THE TXT FILE
     */
    public void writeContact(){
        try {
            try {
                PrintWriter pw = new PrintWriter(fileContact);
                for (int i = 0; i< contactArray.length; i++){
                    if(contactArray[i]!= null){
                        if(!contactArray[i].contains("#delete")){
                            pw.println(contactArray[i]);
                        }
                    }
                }
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            System.out.println(errorWriteT);
            System.out.println(e.toString());
        }
    }

    /**
     *  DELETE QUESTION TO BE SURE YOU REALLY WANT TO DELETE THE CONTACT
     */
    public void deleteConfirmation() {

        int reponse = JOptionPane.showConfirmDialog(this,
                "Suppression du contact. Êtes-vous sur de vouloir le supprimer ?",
                "Suppression",
                JOptionPane.YES_NO_OPTION);


        if (reponse == JOptionPane.YES_OPTION){
            int numJList = contactL.getSelectedIndex();
            // replacing data by deletedField tags
            stream(deletedField, deletedField, deletedField, deletedField, deletedField, deletedField, numJList);
        }
        showDefault();
    }

    /**
     *  UPDATE THE LIST OF CONTACT TO GET THE NEW ADDED
     */
    public void updateList(){
        contactList = new String[contactArray.length];
        contactData = new ContactData[contactArray.length];

        String[] tempArray = new String[7];
        try {
            for (int i = 0; i< contactArray.length; i++){
                if(contactArray[i]!= null){
                    // Separating values to 6 values - used separator is - with a leading and ending space
                    tempArray = contactArray[i].split(" - ", 6);
                    // Creating contactData array contaning the object contactData with it's informations
                    contactData[i] = new ContactData(tempArray[0], tempArray[1], tempArray[2], tempArray[3], tempArray[4], tempArray[5]);
                    // Generating contactList content
                    contactList[i] = tempArray[0] + " " + tempArray[1];
                    if(contactArray[i].contains(deletedField)){
                        contactList[i] = null;
                    }
                }
            }
            contactL.setListData(contactList);
            labelTfPanel.setVisible(false);
            imagePanel.setVisible(false);
            backButton.setVisible(false);
            scrollPanePanel.setVisible(true);
            contactLb.setVisible(true);

        }catch (Exception e){
            System.out.println(errorUpdateT);
            System.out.println(e.toString());
        }
    }


    /**
     * CREATING A TEMPORARY ARRAY AND ADDING EXISTING CONTACT
     * ADD THE NEW CONTACT AT THE END OF THE TEMP ARRAY
     * CALL THE METHOD WRITE CONTACT, UPDATE LIST AND SHOW DEFAULT
     **/
    public void addToStream(){
        String temp [] = new String[contactArray.length + 1];


        for(int i = 0; i < contactArray.length; i++){
            temp[i] = contactArray[i];
        }

        temp[contactArray.length] = firstnameTf.getText() + " - "
                + nameTf.getText() + " - " + emailTf.getText() + " - " + numTf.getText()
                + " - " + adressTf.getText() + " - " + ZIPTf.getText();


        contactArray = new String [temp.length];
        contactArray = temp;

        writeContact();
        updateList();
        showDefault();
    }

    /**
     * ADDING LINES TO THE CONTACT ARRAY WITH NEW CONTACT DATA
     * ALL THE METHOD WRITE CONTACT, UPDATE LIST AND SHOW DEFAULT
     **/

    public void stream(String name, String firstname, String email, String phone, String address, String zipcity, int JListContact) {
        for(int i = 0; i< contactArray.length; i++){
            if(contactArray[i] != null){
                if(i == JListContact){
                    contactArray[i] = firstname + " - " + name + " - " + email + " - " + phone + " - " + address + " - " + zipcity;
                }
            }
        }
        updateList();
        writeContact();
        contactL.setEnabled(true);
        showDefault();
    }

    /**
     * SHOW PHOTO GALLERY WHEN YOU CLIC ON THE + PHOTO TO ADD A PHOTO FOR A CONTACT
     *
     **/
    class AddPhoto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {


            formPanel.setVisible(false);
            labelTfPanel.setVisible(false);
            cancelButton.setVisible(false);
            saveButton.setVisible(false);
            fondEcran.setVisible(false);


            HOMEGALLERY homegallery = new HOMEGALLERY(contact);
            homegallery.setBounds(0,0,310,525);
            add(homegallery);
            setComponentZOrder(homegallery,0);


        }
    }

    /**
     * CHECK IF A CONTACT ALREADY EXIST
     **/
    class ValidateExistingContact implements ActionListener{

        public void actionPerformed(ActionEvent e){
            try {
                int numJList = contactL.getSelectedIndex();
                // Testing the contact form fields
                if(validEmail(emailTf.getText())){
                    emailTf.setForeground(Color.BLACK);
                    if(validPhone(numTf.getText())) {
                        numTf.setForeground(Color.BLACK);
                        // Getting form field values and writing data to the stream
                        stream(nameTf.getText(), firstnameTf.getText(),
                                emailTf.getText(), numTf.getText(), adressTf.getText(),
                                ZIPTf.getText(), numJList);
                    } else {
                        numTf.setForeground(Color.RED);
                    }
                } else {
                    emailTf.setForeground(Color.RED);
                }
                showDefault();
            } catch (Exception f) {
                System.out.println(errorModifyT);
                System.out.println(f.toString());
            }
        }
    }

    /**
     * WHAT HAPPEN WHEN YOU CLIC ON THE DELETEB BOUTONS BUTTON
     * GET THE METHOD DELETE CONFIRMATION
     * AND THEN WHEN THE USER REALLY WANT TO DELETE A CONTACT IT GET BACK TO CONTACT MENU
     **/
    class DeleteContact implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            deleteConfirmation();
            scrollPanePanel.setVisible(true);
            backButton.setVisible(false);
            contactLb.setVisible(true);
        }
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }


    /**
     * CONNECTED TO VALIDATOR TO BE SURE THAT THE DATAS THE USER GIVES ARE IN CORRECT FORMS
     * ONLY NUMBERS FOR THE PHONE AND THE EXACT NUMBER OF FIGURES
     **/
    public boolean validPhone(String phone){
        boolean response;
        response = validator.validatePhone(phone);
        return response;
    }
    public boolean validEmail(String mail){
        boolean response;
        response = validator.validateEmail(mail);
        return response;
    }

    /**
     * EDIT VALUES
     **/
    public void setEditable(boolean val){
        nameTf.setEditable(val);
        firstnameTf.setEditable(val);
        numTf.setEditable(val);
        emailTf.setEditable(val);
        adressTf.setEditable(val);
        ZIPTf.setEditable(val);
    }

    /**
     *BACK TO INITIALS BUTTONS
     **/
    public void showDefault(){
        addButton.setVisible(true);
        editButton.setVisible(false);
        deleteButton.setVisible(false);
        updateButton.setVisible(false);
        saveButton.setVisible(false);
        cancelButton.setVisible(false);
        contactL.setEnabled(true);
    }

    /**
     *SET TEXTFIELD TO NULL
     **/
    public void setFieldsToNULL(){
        nameTf.setText(null);
        firstnameTf.setText(null);
        numTf.setText(null);
        emailTf.setText(null);
        adressTf.setText(null);
        ZIPTf.setText(null);
    }
}
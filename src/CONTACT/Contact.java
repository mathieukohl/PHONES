package CONTACT;

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
     * fichierContact is the file in which the list of contacts is saved
     *
     **/

    //FILE TO FIND SAVED CONTACT
    private static String fichierContact = "C:\\\\Users\\\\mathi\\\\IdeaProjects\\\\PHONES\\\\src\\\\contact.txt";



    //FONT ORGANIZER
    Font fontL = new Font("SansSerif", Font.BOLD, 16);
    Font fontTF = new Font("SansSerif", Font.ITALIC, 16);
    Font fontButton = new Font("Arial", Font.BOLD, 14);
    Font title = new Font("Arial", Font.BOLD, 22);

    //TEXT BUTTON
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


    //TEXT LABEL
    static String nameLabelT = "Nom";
    static String firstnameLabelT = "Prenom";
    static String phoneLabelT = "Numero de telephone";
    static String emailLabelT = "Email";
    static String addressLabelT = "Adresse";
    static String zipcityLabelT = "CP / Ville";

    //ERROE MESSAGE
    static String errorDeleteT = "Un probleme est survenu lors de la suppression.";
    static String errorModifyT = "Une erreur est survenue lors de la modification. Veuillez corriger.";
    static String errorWriteT = "Erreur lors de l'écriture dans le fichier.";
    static String errorUpdateT = "Erreur lors de la modification.";
    static String errorReadT = "Erreur de lecteur.";

    //DELETED STRING
    static String deletedField = "#valeurSupprimee";

    //CONNECT TO VALIDATOR TO VALIDATE (MAIL,PHONE...)
    Validator validator = new Validator();

    //IMAGES FOR BUTTON
    private ImageIcon addContact = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\addb.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon deleteContact = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\deleteb.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    private ImageIcon backContact = new ImageIcon(new ImageIcon("C:\\Users\\mathi\\OneDrive\\Documents\\HES\\S2\\POO\\ProjetPhones\\Images\\backb.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));


    //DIMENSION FOR LABEL & TEXFIELD
    protected Dimension dimension = new Dimension(480, 30);

    //PANELS
    protected JPanel scrollPanePanel = new JPanel();
    protected JPanel buttonPanel = new JPanel();
    protected static JPanel labelTfPanel = new JPanel();
    protected JPanel formPanel = new JPanel();
    protected static JPanel fondEcran = new JPanel();
    protected JPanel suppMessage = new JPanel();

    //LIST
    protected static JList contactL = new JList(); //List which contains the data

    //BUTTONS
    protected static JButton addButton = new JButton(addButtonT);
    protected static JButton editButton	= new JButton(modifyButtonT);
    private static JButton saveButton = new JButton(saveButtonT);
    private static JButton updateButton = new JButton(updateButtonT);
    protected static JButton deleteButton = new JButton(deleteButtonT);
    private static JButton cancelButton	= new JButton(cancelButtonT);
    private static JButton backButton = new JButton(backButtonT);

    //BUTTONS
    private static JButton yesButton = new JButton(yesButtonT);
    private static JButton noButton = new JButton(noButtonT);

    //TEXTFIELD
    private static JTextField
            nameTf = new JTextField(),
            firstnameTf = new JTextField(),
            numTf = new JTextField(),
            emailTf = new JTextField(),
            adressTf = new JTextField(),
            ZIPTf = new JTextField();

    //LABELS
    private JLabel
            contactLb = new JLabel(contactTitle),
            nameLb = new JLabel(nameLabelT),
            firstnameLb = new JLabel(firstnameLabelT),
            numLb = new JLabel(phoneLabelT),
            emailLb = new JLabel(emailLabelT),
            addressLb = new JLabel(addressLabelT),
            ZIPLb = new JLabel(zipcityLabelT);


    //TABS
    private static String[] contactList;
    private static String[] contactArray;
    protected static ContactData[] contactData;

    public Contact() {

        //SCROLLPANE TO SCROLL ON CONTACT LIST
        JScrollPane scrollPane = new JScrollPane(contactL);


        scrollPanePanel.setLayout(new BorderLayout());
        formPanel.setLayout(new BorderLayout());

        //ADD SCROOLPANE
        scrollPanePanel.add(scrollPane,BorderLayout.CENTER);


        formPanel.add(buttonPanel,BorderLayout.NORTH);
        formPanel.add(labelTfPanel,BorderLayout.CENTER);

        //PANEL OF BUTTONS
        //buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);
       // buttonPanel.add(yesButton);
        //buttonPanel.add(noButton);



        //LABEL OF TEXTFIELD
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



        //ADDINGS PANNEL
        add(scrollPanePanel,BorderLayout.NORTH); //CONTACT LIST
        add(formPanel,BorderLayout.SOUTH); //CONTACT WITH DATA

        //HIDE TEXTFIELD LABEL
        labelTfPanel.setVisible(false);

        //HIDE BUTTON
        editButton.setVisible(false);
        saveButton.setVisible(false);
        cancelButton.setVisible(false);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
        backButton.setVisible(false);

        //ACTION LISTENER
        addButton.addActionListener(new AddContact());
        editButton.addActionListener(new EditContact());
        saveButton.addActionListener(new ValidateNewContact());
        cancelButton.addActionListener(new CancelContact());
        updateButton.addActionListener(new ValidateExistingContact());
        deleteButton.addActionListener(new DeleteContact());
        backButton.addActionListener(new BackContact());
        //yesButton.addActionListener(new YesSup());
        //noButton.addActionListener(new NoSup());

        //SELECT LISTENER TO SHOW CONTACT WHEN YOU CLIC ON IT
        contactL.addListSelectionListener(new LSListener());

        //SET SIZE OF DIFFERENT PANEL
        this.setLayout(null);
        this.scrollPanePanel.setBounds(0, 100, 310, 350); //SIZE OF CONTACT LIST
        this.formPanel.setBounds(0, 50, 310, 430); // SIZE OF CONTACT'S DATA




        setStyles();
    }

    public void setStyles(){


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

        // FONT EDIT FOR BUTTON
        addButton.setFont(fontButton);
        editButton.setFont(fontButton);
        saveButton.setFont(fontButton);
        cancelButton.setFont(fontButton);
        updateButton.setFont(fontButton);
        deleteButton.setFont(fontButton);
        backButton.setFont(fontButton);



    }

    //EDIT VALUE
    public void setEditable(boolean val){
        nameTf.setEditable(val);
        firstnameTf.setEditable(val);
        numTf.setEditable(val);
        emailTf.setEditable(val);
        adressTf.setEditable(val);
        ZIPTf.setEditable(val);
    }

    //BACK TO INITIAL
    public void showDefault(){
        addButton.setVisible(true);
        editButton.setVisible(false);
        deleteButton.setVisible(false);
        updateButton.setVisible(false);
        saveButton.setVisible(false);
        cancelButton.setVisible(false);
        contactL.setEnabled(true);
    }

    //SET TEXTFIELD TO NULL
    public void setFieldsToNULL(){
        nameTf.setText(null);
        firstnameTf.setText(null);
        numTf.setText(null);
        emailTf.setText(null);
        adressTf.setText(null);
        ZIPTf.setText(null);
    }

    //GET DATA ON THE TXT FILE
    public void readContact() {
        String ligne;
        try {
            int buffLength = 0;
            BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fichierContact)));
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
            BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fichierContact)));
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

    //ADD DATA ON THE TXT FILE
    public void writeContact(){
        try {
            try {
                PrintWriter pw = new PrintWriter(fichierContact);
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


    //SELECT LISTENER TO SHOW CONTACT WHEN YOU CLIC ON IT
    class LSListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent evt){
            int i = contactL.getSelectedIndex();
            labelTfPanel.setVisible(true); // Show contact form
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

    //DELETE QUESTION TO BE SURE YOU REALLY WANT TO DELETE THE CONTACT
    public void deleteConfirmation() {

        int reponse = JOptionPane.showConfirmDialog(this,
                "Suppression du contact. Êtes-vous sur de vouloir le supprimer ?",
                "Suppression",
                JOptionPane.YES_NO_OPTION);


        if (reponse == JOptionPane.YES_OPTION){
            int numJList = contactL.getSelectedIndex();
            // replacing data by deletedField tags
            streamMod(deletedField, deletedField, deletedField, deletedField, deletedField, deletedField, numJList);
        }
        showDefault();
    }

    //UPDATE THE LIST OF CONTACT TO GET THE NEW ADDED
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
            backButton.setVisible(false);
            scrollPanePanel.setVisible(true);
            contactLb.setVisible(true);

        }catch (Exception e){
            System.out.println(errorUpdateT);
            System.out.println(e.toString());
        }
    }

    //CONNECTED TO VALIDATOR TO BE SURE THAT THE DATAS THE USER GIVES ARE IN CORRECT FORMS
    //ONLY NUMBERS FOR THE PHONE AND THE EXACT NUMBER OF FIGURES
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



    public void addToStream(){
        String temp [] = new String[contactArray.length + 1];

        // Creating temporary array and adding existing contact data
        for(int i = 0; i < contactArray.length; i++){
            temp[i] = contactArray[i];

        }
        // Appending the new contact to the last position of the temp array
        temp[contactArray.length] = firstnameTf.getText() + " - "
                + nameTf.getText() + " - " + emailTf.getText() + " - " + numTf.getText()
                + " - " + adressTf.getText() + " - " + ZIPTf.getText();

        // Redefining contactArray and putting temp data
        contactArray = new String [temp.length];
        contactArray = temp;

        writeContact();
        updateList();
        showDefault();
    }
    public void streamMod(String name, String firstname, String email, String phone, String address, String zipcity, int JListContact) {
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
    class AddContact implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            contactL.setEnabled(false);
            setFieldsToNULL();
            scrollPanePanel.setVisible(false);
            formPanel.setVisible(true);
            labelTfPanel.setVisible(true);
            cancelButton.setVisible(true);
            saveButton.setVisible(true);
            addButton.setVisible(false);
            editButton.setVisible(false);
            deleteButton.setVisible(false);
            updateButton.setVisible(false);
            contactLb.setVisible(false);
            addButton.setVisible(false);
            setEditable(true);
        }
    }
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
            backButton.setVisible(false);
        }
    }
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
    class CancelContact implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                contactL.clearSelection(); // Clearing the contactLF
                labelTfPanel.setVisible(false); // Hiding labelTfPanel
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

    class BackContact implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //contactL.clearSelection(); // Clearing the contactLF
                scrollPanePanel.setVisible(true);
                labelTfPanel.setVisible(false); // Hiding labelTfPanel
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
                        streamMod(nameTf.getText(), firstnameTf.getText(),
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
}
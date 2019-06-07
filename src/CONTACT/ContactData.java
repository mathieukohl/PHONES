package CONTACT;

import javax.swing.*;
import java.io.Serializable;


public class ContactData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * INITIALISATION
     */
    private String firstname;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String zipcity;
   // private ImageIcon image;


    public ContactData(){
        firstname = "";
        name = "";
        email = "";
        phone = "";
        address = "";
        zipcity = "";
    }

    /**
     * STRING OF DATA TO ADD TO NEW CONTACT
     */

    public ContactData(String firstname, String name, String email, String phone, String address, String zipcity) {
        super();
        this.firstname = firstname;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zipcity = zipcity;
       // this.image = image;

    }

    // Getters & Setters

    /**
     *
     * GETTER FOR NAME
     * @return VALUE OF NAME
     *
     */

    public String getName() {
        return name;
    }

    /**
     *
     * SETTER FOR NAME
     * @return VALUE OF NAME
     *
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * GETTER FOR FIRST NAME
     * @return VALUE OF FIRST NAME
     *
     */


    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * SETTER FOR FIRST NAME
     * @return VALUE OF FIRST NAME
     *
     */

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * GETTER FOR EMAIL
     * @return VALUE OF EMAIL
     *
     */


    public String getEmail() {
        return email;
    }

    /**
     *
     * SETTER FOR EMAIL
     * @return VALUE OF EMAIL
     *
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * GETTER FOR PHONE NUMBER
     * @return VALUE OF PHONE NUMBER
     *
     */


    public String getPhone() {
        return phone;
    }

    /**
     *
     * SETTER FOR PHONE NUMBER
     * @return VALUE OF PHONE NUMBER
     *
     */

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * GETTER FOR ADDRESS
     * @return VALUE OF ADDRESS
     *
     */


    public String getAddress() {
        return address;
    }

    /**
     *
     * SETTER FOR ADDRESS
     * @return VALUE OF ADDRESS
     *
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * GETTER FOR ZIP AND CITY
     * @return VALUE OF ZIP AND CITY
     *
     */


    public String getZipcity() {
        return zipcity;
    }

    /**
     *
     * SETTER FOR ZIP AND CITY
     * @return VALUE OF ZIP AND CITY
     *
     */

    public void setZipcity(String zipcity) {
        this.zipcity = zipcity;
    }

}
package CONTACT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {

    public Validator() {
        // TODO Auto-generated constructor stub
    }

    /**
     *
     * METHOD TO VALIDATE THE EMAIL
     * IT CHECK IF YOU HAVE A TEXT THEN THE @ SIGN AND THEN TEXT AGAIN
     * @param email
     * @return boolean
     *
     */

    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher matched = pattern.matcher(email.toUpperCase());
        return matched.matches();
    }

    /**
     *
     * METHOD TO VALIDATE THE PHONE NUMBER
     * YOU NEED TO WRTIE EXACTLY 10 NUMBERS
     * @param phone
     * @return boolean
     *
     */

    public boolean validatePhone(String phone) {
        Pattern pattern = Pattern.compile("\\d{10}");
        Matcher matched = pattern.matcher(phone);
        return matched.matches();
    }

}
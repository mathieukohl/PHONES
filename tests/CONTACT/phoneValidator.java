package CONTACT;

import org.junit.Test;

import static org.junit.Assert.*;

public class phoneValidator {

    @Test
    public void validatePhone() {
        Validator validator = new Validator();
        assertTrue(validator.validatePhone("0788300196"));

    }
}
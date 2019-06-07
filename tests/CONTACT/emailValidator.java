package CONTACT;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class emailValidator {

    @Test
    public void validateEmail() {
        Validator validator = new Validator();
        assertTrue(validator.validateEmail("mathieukohl@yahoo.fr"));

    }
}
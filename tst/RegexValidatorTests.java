package com.pixelduke.javafx.validation.tests;

import com.pixelduke.javafx.validation.RegexValidator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by pedro_000 on 7/8/2014.
 */
public class RegexValidatorTests {
    static final String RESOURCE = "../resource/RegexTextFieldValidationSample.fxml";

    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    @Test
    public void testTextFieldValidationHasErrors() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
        Scene scene = new Scene(root);

        RegexValidator regexValidator = (RegexValidator) scene.lookup("#validator");
        regexValidator.setRegex("a");
        regexValidator.eval();

        assertTrue(regexValidator.getHasErrors());
    }

    @Test
    public void testTextFieldValidationDoesntHaveErrors() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
        Scene scene = new Scene(root);

        TextField textField = (TextField)scene.lookup("#userName");
        textField.setText("a");
        RegexValidator regexValidator = (RegexValidator) scene.lookup("#validator");
        regexValidator.setRegex("a");
        regexValidator.eval();

        assertFalse(regexValidator.getHasErrors());
    }

    @Test
    public void testEmailPatternDoesntHaveErrors() throws IOException
    {
        final String emailPattern =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
        Scene scene = new Scene(root);

        TextField textField = (TextField)scene.lookup("#userName");
        textField.setText("pedro@sapo.pt");
        RegexValidator regexValidator = (RegexValidator) scene.lookup("#validator");
        regexValidator.setRegex(emailPattern);
        regexValidator.eval();

        assertFalse(regexValidator.getHasErrors());
    }

    @Test
    public void testEmailPatternHasErrors() throws IOException
    {
        final String emailPattern =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
        Scene scene = new Scene(root);

        TextField textField = (TextField)scene.lookup("#userName");
        textField.setText("pedro@.pt");
        RegexValidator regexValidator = (RegexValidator) scene.lookup("#validator");
        regexValidator.setRegex(emailPattern);
        regexValidator.eval();

        assertTrue(regexValidator.getHasErrors());
    }

}

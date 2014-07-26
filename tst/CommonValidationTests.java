package com.pixelduke.javafx.validation.tests;

import com.pixelduke.javafx.validation.RegexValidator;
import com.pixelduke.javafx.validation.ValidatorBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by pedro_000 on 7/8/2014.
 */
public class CommonValidationTests {
    static final String RESOURCE = "../resource/RegexTextFieldValidationSample.fxml";

    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    @Test
    public void testErrorStyleClassAppliedOnError() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
        Scene scene = new Scene(root);

        RegexValidator regexValidator = (RegexValidator) scene.lookup("#validator");
        regexValidator.setRegex("a");

        TextField textField = (TextField)scene.lookup("#userName");
        textField.setText("b");
        regexValidator.eval();

        assertTrue(textField.getStyleClass().indexOf(ValidatorBase.DEFAULT_ERROR_STYLE_CLASS) != -1);
    }

}

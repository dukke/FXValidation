package com.pixelduke.javafx.validation.tests;

import com.pixelduke.javafx.validation.CardinalityValidator;
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
 * Created by pedro_000 on 7/7/2014.
 */
public class CardinalityValidatorTests {
    static final String RESOURCE = "../resource/CardinalityValidationSample.fxml";

    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();


    @Test
    public void testBelowMinValidationHasErrors() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
        Scene scene = new Scene(root);
        CardinalityValidator cardinalityValidator = (CardinalityValidator) scene.lookup("#validator");
        TextField textField = (TextField) scene.lookup("#userName");

        cardinalityValidator.setMin(5);
        textField.setText("xpto");
        cardinalityValidator.eval();

        assertTrue(cardinalityValidator.getHasErrors());
    }

    @Test
    public void testMinValidationDoesntHaveErrors() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
        Scene scene = new Scene(root);
        CardinalityValidator cardinalityValidator = (CardinalityValidator) scene.lookup("#validator");
        TextField textField = (TextField) scene.lookup("#userName");

        cardinalityValidator.setMin(5);
        textField.setText("123456");
        cardinalityValidator.eval();

        assertFalse(cardinalityValidator.getHasErrors());
    }

    @Test
    public void testAboveMaxValidationHasErrors() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
        Scene scene = new Scene(root);
        CardinalityValidator cardinalityValidator = (CardinalityValidator) scene.lookup("#validator");
        TextField textField = (TextField) scene.lookup("#userName");

        cardinalityValidator.setMax(5);
        textField.setText("123456");
        cardinalityValidator.eval();

        assertTrue(cardinalityValidator.getHasErrors());
    }

    @Test
    public void testMaxValidationDoesntHaveErrors() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
        Scene scene = new Scene(root);
        CardinalityValidator cardinalityValidator = (CardinalityValidator) scene.lookup("#validator");
        TextField textField = (TextField) scene.lookup("#userName");

        cardinalityValidator.setMax(6);
        textField.setText("123456");
        cardinalityValidator.eval();

        assertFalse(cardinalityValidator.getHasErrors());
    }

    @Test
    public void testMinAndMaxValidationHasErrors() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
        Scene scene = new Scene(root);
        CardinalityValidator cardinalityValidator = (CardinalityValidator) scene.lookup("#validator");
        TextField textField = (TextField) scene.lookup("#userName");

        cardinalityValidator.setMin(3);
        cardinalityValidator.setMax(6);
        textField.setText("1234567");
        cardinalityValidator.eval();

        assertTrue(cardinalityValidator.getHasErrors());
    }

    @Test
    public void testMinAndMaxValidationDoesntHaveErrors() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
        Scene scene = new Scene(root);
        CardinalityValidator cardinalityValidator = (CardinalityValidator) scene.lookup("#validator");
        TextField textField = (TextField) scene.lookup("#userName");

        cardinalityValidator.setMin(3);
        cardinalityValidator.setMax(10);
        textField.setText("1234567");
        cardinalityValidator.eval();

        assertFalse(cardinalityValidator.getHasErrors());
    }


}

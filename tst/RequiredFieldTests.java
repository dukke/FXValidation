package com.pixelduke.javafx.validation.tests;

import com.pixelduke.javafx.validation.RequiredField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

/**
 * Created by pedro_000 on 7/2/2014.
 */
public class RequiredFieldTests {
    static final String TEXT_FIELD_RESOURCE = "../resource/TextFieldRequiredFieldValidationSample.fxml";
    static final String COMBO_BOX_RESOURCE = "../resource/ComboBoxRequiredFieldValidationSample.fxml";


    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    @Test
    public void testFXMLGetSrcControl() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(TEXT_FIELD_RESOURCE));
        Scene scene = new Scene(root);

        RequiredField requiredField = (RequiredField) scene.lookup("#validator");
        TextField textField = (TextField) requiredField.getSrcControl();

        assertNotNull(textField);
    }

    @Test
    public void testTextFieldValidationHasErrors() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(TEXT_FIELD_RESOURCE));
        Scene scene = new Scene(root);

        RequiredField requiredField = (RequiredField) scene.lookup("#validator");
        requiredField.eval();

        assertTrue(requiredField.getHasErrors());
    }

    @Test
    public void testTextFieldValidationDoesntHaveErrors() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(TEXT_FIELD_RESOURCE));
        Scene scene = new Scene(root);

        TextField textField = (TextField)scene.lookup("#userName");
        textField.setText("some text");
        RequiredField requiredField = (RequiredField) scene.lookup("#validator");
        requiredField.eval();

        assertFalse(requiredField.getHasErrors());
    }

    @Test
    public void testComboBoxValidationHasErrors() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(COMBO_BOX_RESOURCE));
        Scene scene = new Scene(root);

        RequiredField requiredField = (RequiredField) scene.lookup("#validator");
        requiredField.eval();

        assertTrue(requiredField.getHasErrors());
    }

    @Test
    public void testComboBoxValidationDoesntErrors() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(COMBO_BOX_RESOURCE));
        Scene scene = new Scene(root);

        ComboBox comboBox = (ComboBox) scene.lookup("#comboBox");
        comboBox.getSelectionModel().select(1);
        RequiredField requiredField = (RequiredField) scene.lookup("#validator");
        requiredField.eval();

        assertFalse(requiredField.getHasErrors());
    }

}

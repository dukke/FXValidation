package com.pixelduke.javafx.validation;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextInputControl;

import java.util.regex.Pattern;

/**
 * Created by pedro_000 on 7/2/2014.
 */
public class RequiredField extends ValidatorBase {

    public RequiredField()
    {
    }

    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    @Override
    public void eval()
    {
        if(srcControl.get() instanceof TextInputControl)
            evalTextInputField();
        else if (srcControl.get() instanceof ComboBox)
            evalComboBox();

    }

    @Override
    public void eval(String regex)
    {
        if(srcControl.get() instanceof TextInputControl)
            evalTextInputField(regex);
        else if (srcControl.get() instanceof ComboBox)
            evalComboBox();

    }

    protected void evalComboBox() {
        ComboBox comboBox = (ComboBox) srcControl.get();

        if (comboBox.getValue() == null || comboBox.getValue().toString().trim().isEmpty())
            hasErrors.set(true);
        else
            hasErrors.set(false);

        onEval();
    }

    protected void evalTextInputField()
    {
        TextInputControl textField = (TextInputControl) srcControl.get();
        if (textField.getText() == null || textField.getText().equals(""))
            hasErrors.set(true);
        else
            hasErrors.set(false);

        onEval();
    }

    protected void evalTextInputField(String regex)
    {
        TextInputControl textField = (TextInputControl) srcControl.get();
        if (textField.getText() == null || Pattern.compile(regex).matcher(textField.getText()).matches())
            hasErrors.set(true);
        else
            hasErrors.set(false);

        onEval();
    }




    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

}

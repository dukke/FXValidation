package com.pixelduke.javafx.validation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextInputControl;

import java.util.regex.Pattern;

/**
 * Created by pedro_000 on 7/7/2014.
 */
public class RegexValidator extends ValidatorBase{

    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    @Override
    public void eval() {
        if(srcControl.get() instanceof TextInputControl)
            evalTextInputField();
    }

    private void evalTextInputField()
    {
        TextInputControl textField = (TextInputControl) srcControl.get();
        if (regex.get() == null || regex.get().trim().isEmpty())
            hasErrors.set(false);
        else
        {
            String text = textField.getText();
            hasErrors.set(!evalString(text));
        }

        onEval();
    }

    protected boolean evalString(String text)
    {
        if (text == null)
            return false;
        else
        {
            return Pattern.matches(regex.get(), text);
        }
    }

    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

    /***** regex string *****/
    protected SimpleStringProperty regex = new SimpleStringProperty();

    public void setRegex(String regex)
    {
        this.regex.set(regex);
    }

    public String getRegex()
    {
        return this.regex.get();
    }

    public StringProperty regexProperty()
    {
        return this.regex;
    }

}

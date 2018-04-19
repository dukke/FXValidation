package com.pixelduke.javafx.utils;

import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextInputControl;

import java.util.regex.Pattern;

/**
 * Created by Diorge Jorge on 18/04/2018.
 */
public class EvalUtils {
    public static void eval(ReadOnlyBooleanWrapper hasErrors, SimpleObjectProperty<Node> srcControl,Boolean required){
        if(srcControl.get() instanceof TextInputControl)
            evalTextInputField(hasErrors, srcControl,required);
        else if (srcControl.get() instanceof ComboBox)
            evalComboBox(hasErrors, srcControl);
    }

    public static void eval(ReadOnlyBooleanWrapper hasErrors, SimpleObjectProperty<Node> srcControl,String regex,Boolean required){
        if(srcControl.get() instanceof TextInputControl)
            if(regex!=null) {
                evalTextInputField(hasErrors, srcControl, regex,required);
            }else{
                evalTextInputField(hasErrors, srcControl,required);
            }
        else if (srcControl.get() instanceof ComboBox)
            evalComboBox(hasErrors, srcControl);
    }

    private static void evalComboBox(ReadOnlyBooleanWrapper hasErrors, SimpleObjectProperty<Node> srcControl) {
        ComboBox comboBox = (ComboBox) srcControl.get();

        if (comboBox.getValue() == null || comboBox.getValue().toString().trim().isEmpty())
            hasErrors.set(true);
        else
            hasErrors.set(false);
    }

    private static void evalTextInputField(ReadOnlyBooleanWrapper hasErrors, SimpleObjectProperty<Node> srcControl,Boolean required) {
        TextInputControl textField = (TextInputControl) srcControl.get();
        if(required) {
            if (textField.getText() == null || textField.getText().equals(""))
                hasErrors.set(true);
            else
                hasErrors.set(false);
        }

    }

    private static void evalTextInputField(ReadOnlyBooleanWrapper hasErrors, SimpleObjectProperty<Node> srcControl, String regex,Boolean required) {
        TextInputControl textField = (TextInputControl) srcControl.get();
        if(required) {
            if ((textField.getText() == null || textField.getText().equals(""))) {
                hasErrors.set(true);
            }
        }
        if (!Pattern.compile(regex).matcher(textField.getText()).matches()){
            hasErrors.set(true);
        }
    }
}

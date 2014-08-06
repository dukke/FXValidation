package com.pixelduke.javafx.validation.tests;

import com.pixelduke.javafx.validation.RequiredField;
import javafx.event.ActionEvent;

/**
 * Created by pedro_000 on 7/8/2014.
 */
public class TextInputSampleController {
    public RequiredField requiredField1;
    public RequiredField requiredField2;

    public void submitPressed(ActionEvent actionEvent) {
        requiredField1.eval();
        requiredField2.eval();
    }
}

package com.pixelduke.javafx.validation;

import com.pixelduke.javafx.utils.EvalUtils;
import javafx.scene.control.TextInputControl;

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
            EvalUtils.eval(hasErrors,srcControl,false);
        onEval();
    }

    @Override
    public void eval(String regex) {
        if(srcControl.get() instanceof TextInputControl)
            EvalUtils.eval(hasErrors,srcControl,regex,false);
        onEval();
    }

}

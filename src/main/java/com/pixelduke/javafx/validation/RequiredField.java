package com.pixelduke.javafx.validation;

import com.pixelduke.javafx.utils.EvalUtils;

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
        EvalUtils.eval(hasErrors,srcControl,true);
        onEval();

    }

    @Override
    public void eval(String regex)
    {
        EvalUtils.eval(hasErrors,srcControl,regex,true);
        onEval();

    }

    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

}

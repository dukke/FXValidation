package com.pixelduke.javafx.validation;

import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 * Created by pedro_000 on 7/5/2014.
 */
public abstract class ValidatorBase extends Parent {
    public static final String DEFAULT_ERROR_STYLE_CLASS = "error";

    public ValidatorBase()
    {
        parentProperty().addListener(new ChangeListener<Parent>() {
            @Override
            public void changed(ObservableValue<? extends Parent> observable, Parent oldValue, Parent newValue) {
                parentChanged();
            }
        });
    }

    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    private void parentChanged() {
        updateSrcControl();
    }

    private void updateSrcControl()
    {
        Parent parent = getParent();
        if (parent != null) {
            Node control = parent.lookup(getSrc());
            srcControl.set(control);
        }
    }

    public abstract void eval();
    public abstract void eval(String regex);

    protected void onEval()
    {
        Node control = getSrcControl();
        if (hasErrors.get()) {
            if (control.getStyleClass().indexOf(errorStyleClass) == -1)
                control.getStyleClass().add(errorStyleClass.get());
        } else
        {
            control.getStyleClass().remove(errorStyleClass.get());
        }
    }

    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

    /***** srcControl *****/
    protected SimpleObjectProperty<Node> srcControl = new SimpleObjectProperty<>();

    public void setSrcControl(Node srcControl)
    {
        this.srcControl.set(srcControl);
    }

    public Node getSrcControl()
    {
        return this.srcControl.get();
    }

    public ObjectProperty srcControlProperty()
    {
        return this.srcControl;
    }

    /***** hasErrors *****/
    protected ReadOnlyBooleanWrapper hasErrors = new ReadOnlyBooleanWrapper(false);

    public boolean getHasErrors()
    {
        return hasErrors.get();
    }

    public ReadOnlyBooleanProperty hasErrorsProperty(){
        return hasErrors.getReadOnlyProperty();
    }

    /***** src *****/
    protected SimpleStringProperty src = new SimpleStringProperty()
    {
        @Override
        protected void invalidated() {
            updateSrcControl();
        }
    };

    public void setSrc(String src)
    {
        this.src.set(src);
    }

    public String getSrc()
    {
        return this.src.get();
    }

    public StringProperty srcProperty()
    {
        return this.src;
    }

    /***** error style class *****/
    protected SimpleStringProperty errorStyleClass = new SimpleStringProperty(DEFAULT_ERROR_STYLE_CLASS);

    public void setErrorStyleClass(String styleClass)
    {
        this.errorStyleClass.set(styleClass);
    }

    public String getErrorStyleClass()
    {
        return this.errorStyleClass.get();
    }

    public StringProperty errorStyleClassProperty()
    {
        return this.errorStyleClass;
    }

}


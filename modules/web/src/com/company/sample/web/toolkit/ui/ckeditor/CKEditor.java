package com.company.sample.web.toolkit.ui.ckeditor;

import com.google.common.base.Strings;
import com.haulmont.cuba.web.widgets.WebJarResource;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.data.HasValue;
import com.vaadin.event.HasUserOriginated;
import com.vaadin.event.SerializableEventListener;
import com.vaadin.shared.Registration;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;
import java.util.EventObject;
import java.util.Objects;

@WebJarResource({"jquery:jquery.min.js"})
@JavaScript({
        "ckeditor-connector.js",
        "vaadin://resources/ckeditor/ckeditor.js",
        "vaadin://resources/ckeditor/config.js",
        "vaadin://resources/ckeditor/styles.js"
})
@StyleSheet({
        "vaadin://resources/ckeditor/contents.css",
        "vaadin://resources/ckeditor/skins/moono-lisa/editor.css"
})
public class CKEditor extends AbstractJavaScriptComponent {

    public CKEditor() {
        addFunction("valueChanged", arguments -> {
            getState(false).value = arguments.getString(0);
            fireEvent(createValueChange(true));
        });
    }

    @Override
    protected CKEditorState getState() {
        return (CKEditorState) super.getState();
    }

    @Override
    protected CKEditorState getState(boolean markAsDirty) {
        return (CKEditorState) super.getState(markAsDirty);
    }

    public String getValue() {
        return getState(false).value;
    }

    public void setValue(String value) {
        if (isDifferentValue(value)) {
            getState().value = Strings.nullToEmpty(value);
            fireEvent(createValueChange(false));
        }
    }

    protected boolean isDifferentValue(String newValue) {
        return !Objects.equals(newValue, getValue());
    }

    public Registration addValueChangeListener(ValueChangeListener listener) {
        return addListener(ValueChangeEvent.class, listener, ValueChangeListener.VALUE_CHANGE_METHOD);
    }

    protected ValueChangeEvent createValueChange(boolean userOriginated) {
        return new ValueChangeEvent(this, userOriginated);
    }

    public interface ValueChangeListener extends SerializableEventListener {

        Method VALUE_CHANGE_METHOD = ReflectTools
                .findMethod(ValueChangeListener.class, "valueChange", ValueChangeEvent.class);

        void valueChange(ValueChangeEvent event);
    }

    public static class ValueChangeEvent extends EventObject implements HasUserOriginated {

        private final boolean userOriginated;

        private final String value;

        public ValueChangeEvent(CKEditor editor, boolean userOriginated) {
            super(editor);
            this.userOriginated = userOriginated;
            this.value = editor.getValue();
        }

        public String getValue() {
            return value;
        }

        @Override
        public boolean isUserOriginated() {
            return userOriginated;
        }

        @Override
        public CKEditor getSource() {
            return (CKEditor) super.getSource();
        }
    }
}
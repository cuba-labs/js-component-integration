package com.company.sample.web.toolkit.ui.ckeditor;

import com.google.common.base.Strings;
import com.haulmont.cuba.web.widgets.WebJarResource;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.shared.ui.JavaScriptComponentState;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.annotations.JavaScript;

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
public class CKEditorServerComponent extends AbstractJavaScriptComponent {

    public CKEditorServerComponent() {
        addFunction("valueChanged", arguments ->
                getState(false).value = arguments.getString(0));
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
        getState().value = Strings.nullToEmpty(value);
    }
}
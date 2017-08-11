package com.company.sample.web.toolkit.ui.ckeditor;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.annotations.JavaScript;

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
    }

    @Override
    protected CKEditorState getState() {
        return (CKEditorState) super.getState();
    }
}
package com.company.sample.web.toolkit.ui.ckeditor;

import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.annotations.JavaScript;

@JavaScript({"ckeditor-connector.js"})
public class CKEditorServerComponent extends AbstractJavaScriptComponent {
    public CKEditorServerComponent() {
    }

    @Override
    protected CKEditorState getState() {
        return (CKEditorState) super.getState();
    }
}
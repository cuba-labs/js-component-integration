package com.company.sample.web.screens;

import com.company.sample.web.toolkit.ui.ckeditor.CKEditorServerComponent;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.vaadin.ui.Layout;

import java.util.Map;

public class Screen extends AbstractWindow {
    @Override
    public void init(Map<String, Object> params) {
        CKEditorServerComponent ckeditor = new CKEditorServerComponent();
        this.unwrap(Layout.class).addComponent(ckeditor);
    }
}
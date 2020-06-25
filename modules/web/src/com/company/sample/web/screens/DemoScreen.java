package com.company.sample.web.screens;

import com.company.sample.web.toolkit.ui.ckeditor.CKEditorServerComponent;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.ContentMode;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.vaadin.ui.AbstractOrderedLayout;

import javax.inject.Inject;

@UiController("sample_DemoScreen")
@UiDescriptor("demo-screen.xml")
public class DemoScreen extends Screen {

    @Inject
    private VBoxLayout editorBox;

    @Inject
    private Notifications notifications;

    private CKEditorServerComponent ckEditor;

    @Subscribe
    public void onInit(InitEvent event) {
        ckEditor = new CKEditorServerComponent();
        editorBox.unwrap(AbstractOrderedLayout.class).addComponent(ckEditor, 0);
    }

    @Subscribe("showValueBtn")
    public void onShowValueBtnClick(Button.ClickEvent event) {
        String value = ckEditor.getValue();
        notifications.create()
                .withCaption("Value")
                .withDescription(value)
                .withContentMode(ContentMode.HTML)
                .show();
    }

    @Subscribe("setValueBtn")
    public void onSetValueBtnClick(Button.ClickEvent event) {
        ckEditor.setValue("<p><i>Italic</i> <strong>bold</strong> " +
                "<a href=\"https://www.cuba-platform.com/discuss/\">https://www.cuba-platform.com/discuss/</a>" +
                "</p><ul><li>Option 1</li><li>Option 2</li></ul><ol><li>Step 1</li><li>Step 2</li>" +
                "</ol><blockquote><p>Quote</p></blockquote>");
    }
}
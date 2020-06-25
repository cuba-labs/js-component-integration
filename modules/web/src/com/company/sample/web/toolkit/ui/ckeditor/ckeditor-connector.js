com_company_sample_web_toolkit_ui_ckeditor_CKEditor = function() {
    var connector = this;
    var element = connector.getElement();
    $(element).html("<textarea/>");
    var editor = CKEDITOR.replace(element);

    // The "change" event is fired whenever a change is made in the editor.
    editor.on( 'change', function( evt ) {
        // getData() returns CKEditor's HTML content.
        connector.valueChanged(evt.editor.getData());
    });

    connector.onStateChange = function () {
        if (editor) {
            var state = connector.getState();
            editor.setData(state.value);
        }
    }
}
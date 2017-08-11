com_company_sample_web_toolkit_ui_ckeditor_CKEditorServerComponent = function() {
    var connector = this;
    var element = connector.getElement();
    $(element).html("<textarea/>");
    CKEDITOR.replace(element);
}
package com.example.contactmgr.app.client.ui.mobile;

import com.example.contactmgr.app.shared.domain.Contact;
import com.example.contactmgr.common.client.ui.web.ViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by david on 3/10/15.
 */
public class ContactDetailViewImpl extends ViewImpl<ContactDetailView.Delegate> implements ContactDetailView {

    private Contact contact;

    interface ContactDetailViewImplUiBinder extends UiBinder<Widget, ContactDetailViewImpl> {}
    private static ContactDetailViewImplUiBinder ourUiBinder = GWT.create(ContactDetailViewImplUiBinder.class);

    public ContactDetailViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiField
    public TextBox firstName;
    @UiField
    public TextBox lastName;
    @UiField
    public TextBox email;
    @UiField
    public Button saveButton;
    @UiField
    public Button cancelButton;

    @Override
    public Contact getContact() {
        return this.contact;
    }

    @Override
    public void setContact(Contact contact) {
        this.contact = contact;
        firstName.setText(contact.getFirstName());
        lastName.setText(contact.getLastName());
    }

    @UiHandler("saveButton")
    public void saveContact(ClickEvent e) {
        this.contact.setFirstName(firstName.getText());
        this.contact.setLastName(lastName.getText());
        getPresenter().saveContact(this.contact);
    }

    @UiHandler("cancelButton")
    public void cancel(ClickEvent e) {
        getPresenter().cancelEdit();
    }
}
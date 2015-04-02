package com.example.contactmgr.client.view.impl;

import com.example.contactmgr.client.view.ContactDetailView;
import com.example.contactmgr.shared.domain.Contact;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.turbomanage.gwt.client.ViewImpl;

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

    @Override
    public Contact getContact() {
        return null;
    }

    @Override
    public void setContact(Contact contact) {
    }

}
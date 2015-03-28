package com.example.contactmgr.app.client.ui.mobile;

import com.example.contactmgr.app.shared.domain.Contact;
import com.example.contactmgr.common.client.ui.web.ViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
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

    @Override
    public Contact getContact() {
        return null;
    }

    @Override
    public void setContact(Contact contact) {
    }

}
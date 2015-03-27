package com.example.contactmgr.app.client;

import com.example.listmaker.app.client.ui.mobile.ContactDetailView;
import com.example.listmaker.app.client.ui.mobile.ContactDetailViewImpl;
import com.example.listmaker.app.client.ui.mobile.ContactsView;
import com.example.listmaker.app.client.ui.mobile.ContactsViewImpl;

/**
 * Manages instances of Views.
 */
public class ClientFactoryImpl implements ClientFactory {

    private ContactsView contactsView;
    private ContactDetailView contactDetailView;

    @Override
    public ContactsView getContactsView() {
        if (contactsView == null) {
            contactsView = new ContactsViewImpl();
        }
        return contactsView;
    }

    @Override
    public ContactDetailView getContactDetailView() {
        if (contactDetailView == null) {
            contactDetailView = new ContactDetailViewImpl();
        }
        return contactDetailView;
    }

}
package com.example.contactmgr.client.ioc.impl;

import com.example.contactmgr.client.ioc.ClientFactory;
import com.example.contactmgr.client.view.ContactDetailView;

import com.example.contactmgr.client.view.impl.ContactDetailViewImpl;
import com.example.contactmgr.client.view.ContactsView;
import com.example.contactmgr.client.view.impl.ContactsViewImpl;

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
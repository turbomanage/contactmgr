package com.example.listmaker.app.client;

import com.example.listmaker.app.client.ui.mobile.ContactDetailView;
import com.example.listmaker.app.client.ui.mobile.ContactDetailViewImpl;
import com.example.listmaker.app.client.ui.mobile.ContactsView;
import com.example.listmaker.app.client.ui.mobile.ContactsViewImpl;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

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
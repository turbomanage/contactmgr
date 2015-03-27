package com.example.contactmgr.app.client;

import com.example.listmaker.app.client.ui.mobile.ContactDetailView;
import com.example.listmaker.app.client.ui.mobile.ContactsView;

/**
 * Created by Gene on 6/5/2014.
 */
public interface ClientFactory {

    ContactsView getContactsView();
    ContactDetailView getContactDetailView();

}

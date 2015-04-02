package com.example.contactmgr.client.ioc;

import com.example.contactmgr.client.view.ContactDetailView;
import com.example.contactmgr.client.view.ContactsView;

/**
 * Created by Gene on 6/5/2014.
 */
public interface ClientFactory {

    ContactsView getContactsView();
    ContactDetailView getContactDetailView();

}

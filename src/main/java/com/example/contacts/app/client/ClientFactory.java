package com.example.contacts.app.client;

import com.example.contacts.app.client.api.ContactsView;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Created by Gene on 6/5/2014.
 */
public interface ClientFactory {

    EventBus getEventBus();
    PlaceController getPlaceController();

    ContactsView getContactsView();
}

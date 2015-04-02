package com.example.contactmgr.client.activity;

import com.example.contactmgr.client.App;
import com.example.contactmgr.client.place.ContactDetailPlace;
import com.example.contactmgr.client.service.AppCallback;
import com.example.contactmgr.client.view.ContactDetailView;
import com.example.contactmgr.shared.domain.Contact;
import com.turbomanage.gwt.client.ActivityPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Created by david on 3/10/15.
 */
public class ContactDetailActivity extends ActivityPresenter<ContactDetailView> implements ContactDetailView.Delegate {

    private final int contactIndex;

    public ContactDetailActivity(ContactDetailPlace place) {
        // Extract id from token and find this record
        contactIndex = place.getSelectedContactIdx();
    }

    @Override
    public void start(AcceptsOneWidget acceptsOneWidget, EventBus eventBus) {
        bind(App.clientFactory().getContactDetailView());
        super.start(acceptsOneWidget, eventBus);
        if (contactIndex < 0) {
            // new place
            getView().setContact(new Contact());
        } else {
            getView().setContact(App.model().getContactStore().getList().get(contactIndex));
        }
    }

    @Override
    public void saveContact(Contact contact) {
        App.serviceFactory().contactService().save(contact, new AppCallback<Contact>() {
            @Override
            public void handleSuccess(Contact result) {
                History.back();
            }
        });
    }

    @Override
    public void cancelEdit() {
        History.back();
    }
}

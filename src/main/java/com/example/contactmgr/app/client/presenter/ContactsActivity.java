package com.example.contactmgr.app.client.presenter;

import com.example.contactmgr.app.client.App;
import com.example.contactmgr.app.client.place.ContactDetailPlace;
import com.example.contactmgr.app.client.service.AppCallback;
import com.example.contactmgr.app.client.service.ContactService;
import com.example.contactmgr.app.client.ui.mobile.ContactsView;
import com.example.contactmgr.app.shared.domain.Contact;
import com.example.contactmgr.common.client.presenter.ActivityPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.turbomanage.gwt.client.rest.ListResponse;

/**
 * Created by david on 2/26/15.
 */
public class ContactsActivity extends ActivityPresenter<ContactsView> implements ContactsView.Delegate {

    private static final ContactService svc = App.serviceFactory().contactService();

    public ContactsActivity() {

    }

    @Override
    public void start(AcceptsOneWidget acceptsOneWidget, EventBus eventBus) {
        bind(App.clientFactory().getContactsView());
        super.start(acceptsOneWidget, eventBus);
        svc.listAll(new AppCallback<ListResponse<Contact>>() {
            @Override
            public void handleSuccess(ListResponse<Contact> result) {
                App.model().getContactStore().replaceAll(result.list);
            }
        });
        // add event handlers
    }

    @Override
    public void newContact() {
        App.placeController().goTo(new ContactDetailPlace(-1));
    }

}
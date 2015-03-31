package com.example.contactmgr.client.view;

import com.example.contactmgr.shared.domain.Contact;
import com.turbomanage.gwt.client.Presenter;
import com.turbomanage.gwt.client.View;

/**
 * Created by david on 2/26/15.
 */
public interface ContactDetailView extends View<ContactDetailView.Delegate> {

    interface Delegate extends Presenter<ContactDetailView> {
        void saveContact(Contact contact);

        void cancelEdit();
    }

    public Contact getContact();

    public void setContact(Contact contact);
}

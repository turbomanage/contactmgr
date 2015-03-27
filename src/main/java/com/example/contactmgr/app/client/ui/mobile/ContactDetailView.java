package com.example.contactmgr.app.client.ui.mobile;

import com.example.contactmgr.app.shared.domain.Contact;
import com.example.contactmgr.common.client.presenter.Presenter;
import com.example.contactmgr.common.client.ui.web.View;

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

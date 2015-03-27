package com.example.contactmgr.app.client.ui.mobile;

import com.example.contactmgr.common.client.presenter.Presenter;
import com.example.contactmgr.common.client.ui.web.View;

/**
 * Created by david on 2/26/15.
 */
public interface ContactsView extends View<ContactsView.Delegate> {

    interface Delegate extends Presenter<ContactsView> {

        void newContact();

    }

}

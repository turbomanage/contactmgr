package com.example.contactmgr.client.view;

import com.turbomanage.gwt.client.Presenter;
import com.turbomanage.gwt.client.View;

/**
 * Created by david on 2/26/15.
 */
public interface ContactsView extends View<ContactsView.Delegate> {

    interface Delegate extends Presenter<ContactsView> {

        void newContact();

    }

}

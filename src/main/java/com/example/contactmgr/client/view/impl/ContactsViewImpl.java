package com.example.contactmgr.client.view.impl;

import com.example.contactmgr.client.view.ContactsView;
import com.example.contactmgr.shared.domain.Contact;
import com.turbomanage.gwt.client.ViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

/**
 * Created by david on 2/26/15.
 */
public class ContactsViewImpl extends ViewImpl<ContactsView.Delegate> implements ContactsView {

    // init store
    private final ListDataProvider<Contact> contactStore = new ListDataProvider<Contact>();

    interface OurUiBinder extends UiBinder<Widget, ContactsViewImpl> { }
    private static OurUiBinder ourUiBinder = GWT.create(OurUiBinder.class);

    @UiField
    public CellTable<Contact> contactCellTable;

    @UiFactory
    public CellTable<Contact> makeContactsTable() {
        CellTable<Contact> contactsTable = new CellTable<Contact>();
        contactsTable.addColumn(new TextColumn<Contact>() {
            @Override
            public String getValue(Contact contact) {
                return contact.getFirstName();
            }
        });
        contactsTable.addColumn(new TextColumn<Contact>() {
            @Override
            public String getValue(Contact contact) {
                return contact.getLastName();
            }
        });
        contactStore.addDataDisplay(contactsTable);
        return contactsTable;
    }

    public ContactsViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("newButton")
    public void onClickNewContact(ClickEvent e) {
        getPresenter().newContact();
    }
}

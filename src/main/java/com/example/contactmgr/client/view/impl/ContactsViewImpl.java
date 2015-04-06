package com.example.contactmgr.client.view.impl;

import com.example.contactmgr.client.App;
import com.example.contactmgr.client.place.ContactDetailPlace;
import com.example.contactmgr.client.view.ContactsView;
import com.example.contactmgr.shared.domain.Contact;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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

    interface OurUiBinder extends UiBinder<Widget, ContactsViewImpl> { }
    private static OurUiBinder ourUiBinder = GWT.create(OurUiBinder.class);

    @UiField
    public CellTable<Contact> contactCellTable;

    @UiFactory
    public CellTable<Contact> makeContactsTable() {
        final CellTable<Contact> contactsTable = new CellTable<Contact>();
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
        getContactStore().addDataDisplay(contactsTable);
        contactsTable.addDomHandler(new ClickHandler() {
          @Override
          public void onClick(ClickEvent clickEvent) {
            // I so love GWT
            Element element = Element.as(clickEvent.getNativeEvent().getEventTarget());
            Element row = element.getParentElement().getParentElement();
            int rowCount = contactCellTable.getRowCount();
            for (int i = 0; i < rowCount ; i++) {
              if (contactCellTable.getRowElement(i) == row) {
                App.placeController().goTo(new ContactDetailPlace(i));
                return;
              }
            }
          }
        }, ClickEvent.getType());
        return contactsTable;
    }

    private ListDataProvider getContactStore() {
      return App.model().getContactStore();
    }

    public ContactsViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("newButton")
    public void onClickNewContact(ClickEvent e) {
        getPresenter().newContact();
    }

}
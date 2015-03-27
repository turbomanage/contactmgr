package com.example.contactmgr.app.client.ui.mobile;

import com.example.contactmgr.app.client.App;
import com.example.contactmgr.app.client.place.ContactDetailPlace;
import com.example.contactmgr.app.shared.domain.Contact;
import com.example.contactmgr.common.client.ui.web.ViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.widget.core.client.ListView;

/**
 * Created by david on 2/26/15.
 */
public class ContactsViewImpl extends ViewImpl<ContactsView.Delegate> implements ContactsView, LongPressContactCell.CellEventHandler {

    interface OurUiBinder extends UiBinder<Widget, ContactsViewImpl> {
    }

    private static OurUiBinder ourUiBinder = GWT.create(OurUiBinder.class);
    @UiField
    public ListView<Contact, Contact> contactListView;
    @UiField
    public Button newButton;

    @UiFactory
    public ListView<Contact, Contact> makeListView() {
        final ListView listView = new ListView(App.model().getContactStore(), new IdentityValueProvider<Contact>(), new LongPressContactCell(this));
        listView.addDomHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                // I so love GWT
                Element element = Element.as(clickEvent.getNativeEvent().getEventTarget());
                int i = listView.findElementIndex(element);
                App.placeController().goTo(new ContactDetailPlace(i));
            }
        }, ClickEvent.getType());
        return listView;
    }

    public ContactsViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("newButton")
    public void onClickNewContact(ClickEvent e) {
        getPresenter().newContact();
    }

    @Override
    public void onCellTap(Element e) {
        int i = contactListView.findElementIndex(e);
        App.placeController().goTo(new ContactDetailPlace(i));
    }

    @Override
    public void onCellLongPress(Element e, Contact c) {
        Window.alert("You selected " + c.getFirstName() + " " + c.getLastName());
    }

}

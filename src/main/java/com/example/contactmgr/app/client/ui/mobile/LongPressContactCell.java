package com.example.contactmgr.app.client.ui.mobile;

import com.example.contactmgr.app.shared.domain.Contact;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Window;
import com.sencha.gxt.cell.core.client.AbstractEventCell;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.gestures.LongPressOrTapGestureRecognizer;
import com.sencha.gxt.core.client.gestures.TouchData;

/**
 * Created by david on 2/26/15.
 */
public class LongPressContactCell extends AbstractEventCell<Contact> {

    interface CellEventHandler {

        void onCellTap(Element e);

        void onCellLongPress(Element e, Contact c);
    }

    private final CellEventHandler cellEventHandler;

    public LongPressContactCell(CellEventHandler cellEventHandler) {
        super();
        this.cellEventHandler = cellEventHandler;
        addCellGestureAdapter(new LongPressOrTapGestureRecognizer.CellLongPressOrTapGestureRecognizer<Contact>() {
            @Override
            protected void onLongPress(TouchData touch, Context context, Element parent, Contact value, ValueUpdater<Contact> updater) {
                LongPressContactCell.this.cellEventHandler.onCellLongPress(parent, value);
            }

            @Override
            protected void onTap(TouchData touch, Context context, Element parent, Contact value, ValueUpdater<Contact> updater) {
                LongPressContactCell.this.cellEventHandler.onCellTap(parent);
            }
        });
        // event-based way of handling LongPressEvent
        addHandler(new LongPressOrTapGestureRecognizer.LongPressEvent.LongPressHandler() {
            @Override
            public void onLongPress(LongPressOrTapGestureRecognizer.LongPressEvent event) {
                Window.alert("hi from LongPressEvent handler");
            }
        }, LongPressOrTapGestureRecognizer.LongPressEvent.TYPE);
    }

    public interface QuoteTemplate extends XTemplates {
        @XTemplates.XTemplate(value = "{firstName} {lastName}")
        SafeHtml quote(Contact q);
    }
    private static final QuoteTemplate quoteTpl = GWT.create(QuoteTemplate.class);

    @Override
    public void render(Context context, Contact c, SafeHtmlBuilder safeHtmlBuilder) {
        safeHtmlBuilder.append(quoteTpl.quote(c));
    }

}
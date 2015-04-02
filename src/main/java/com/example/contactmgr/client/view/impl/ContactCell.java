package com.example.contactmgr.client.view.impl;

import com.example.contactmgr.shared.domain.Contact;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.XTemplates;

/**
 * Created by david on 2/26/15.
 */
public class ContactCell extends AbstractCell<Contact> {

    public interface QuoteTemplate extends XTemplates {
        @XTemplate(value = "{firstName} {lastName}")
        SafeHtml quote(Contact q);
    }
    private static final QuoteTemplate quoteTpl = GWT.create(QuoteTemplate.class);

    @Override
    public void render(Context context, Contact c, SafeHtmlBuilder safeHtmlBuilder) {
        safeHtmlBuilder.append(quoteTpl.quote(c));
    }
}

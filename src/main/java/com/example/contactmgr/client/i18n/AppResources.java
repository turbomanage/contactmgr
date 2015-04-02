package com.example.contactmgr.client.i18n;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * CSS style names
 *
 * @author David Chandler
 */
public interface AppResources extends ClientBundle {
    public static final AppResources INSTANCE = GWT.create(AppResources.class);

    @Source("app.gss")
    AppStyles css();
}


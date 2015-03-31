/*
 * Copyright 2009 David M Chandler All Rights Reserved.
 */

package com.example.contactmgr.client;

import com.example.contactmgr.client.i18n.AppResources;
import com.turbomanage.gwt.client.animation.AnimatedActivityManager;
import com.example.contactmgr.client.place.AppActivityMapper;
import com.example.contactmgr.client.place.ContactsPlace;
import com.example.contactmgr.client.service.AppCallback;
import com.example.contactmgr.client.service.LoginInfoService;
import com.example.contactmgr.shared.domain.User;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.debug.client.DebugInfo;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import org.fusesource.restygwt.client.Defaults;

/**
 * GWT entry point
 */
public class ContactManager implements EntryPoint {

    private SimplePanel mainDisplay = new SimplePanel();
    private Place defaultPlace = new ContactsPlace(null);

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        App.resources().css().ensureInjected();
        Defaults.setDateFormat(null);
        Defaults.setDispatcher(App.getDispatcher());
        DebugInfo.setDebugIdPrefix("");

        addLoggers();
        LoginInfoService loginInfoService = GWT.create(LoginInfoService.class);
        loginInfoService.login(GWT.getHostPageBaseURL(), new AppCallback<User>() {
            @Override
            public void handleSuccess(User me) {
                App.model().setMe(me);
                loadApp();
            }
        });
    }

    private void loadApp() {
        //gwt-activities-and-places
        ActivityMapper mainActivityMapper = new AppActivityMapper();
        AnimatedActivityManager mainActivityManager = new AnimatedActivityManager(mainActivityMapper, App.eventBus(), App.historyMapper(), App.placeController());
        mainActivityManager.setDisplay(mainDisplay);

        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(App.historyMapper());
        historyHandler.register(App.placeController(), App.eventBus(), defaultPlace);
        DOM.removeChild(RootPanel.getBodyElement(), DOM.getElementById("loading"));

        RootPanel.get("app").add(mainDisplay);

        historyHandler.handleCurrentHistory();
    }

    private void addLoggers() {
        App.eventBus().addHandler(ValueChangeEvent.getType(), new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                App.getLogger().finest("VCE " + event.getValue());
            }
        });
    }

}

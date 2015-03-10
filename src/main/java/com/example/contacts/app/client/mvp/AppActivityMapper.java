package com.example.contacts.app.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.example.contacts.app.client.presenter.*;
import com.example.contacts.app.client.place.*;

/**
* Created by Gene on 6/5/2014.
*/
public class AppActivityMapper implements ActivityMapper {

    public AppActivityMapper() {
        super();
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof HomePlace) {
            return new ContactsActivity();
        }
        return null;
    }
}


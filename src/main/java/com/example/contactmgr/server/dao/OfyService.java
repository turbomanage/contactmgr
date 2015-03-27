package com.example.contactmgr.server.dao;

import com.example.contactmgr.app.shared.domain.Contact;
import com.example.contactmgr.app.shared.domain.User;
import com.example.contactmgr.server.domain.UserSession;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Created by david on 7/3/14.
 */
public class OfyService {

    static {
        ObjectifyService.register(Contact.class);
        ObjectifyService.register(User.class);
        ObjectifyService.register(UserSession.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
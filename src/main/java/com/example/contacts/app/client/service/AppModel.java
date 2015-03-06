package com.example.contacts.app.client.service;

import com.example.contacts.app.client.domain.User;

/**
 * Singleton that represents the current state of the UI. Getters
 * are public to be called from various other presenters, whereas
 * setters are package access to be called only by service facades.
 * Setters may fire an event to notify listening widgets that the
 * model has been updated.
 * 
 * @author David Chandler
 */
public class AppModel
{
    private User me;

    public User getMe() {
        return me;
    }

    public void setMe(User me) {
        this.me = me;
    }

}

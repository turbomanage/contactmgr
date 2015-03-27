package com.example.contactmgr.app.client.ui.mobile;

import com.example.contactmgr.app.client.service.ContactService;

/**
 * Created by david on 3/10/15.
 */
public interface ServiceFactory {

    ContactService contactService();
}

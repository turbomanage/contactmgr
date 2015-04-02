package com.example.contactmgr.client.ioc;

import com.example.contactmgr.client.service.ContactService;

/**
 * Created by david on 3/10/15.
 */
public interface ServiceFactory {

    ContactService contactService();
}

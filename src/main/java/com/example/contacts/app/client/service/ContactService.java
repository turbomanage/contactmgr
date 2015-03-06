package com.example.contacts.app.client.service;

import com.example.contacts.common.domain.Contact;
import com.turbomanage.gwt.client.rest.RestApi;

import javax.ws.rs.Path;

/**
 * Created by david on 2/26/15.
 */
@Path("contact")
public interface ContactService extends RestApi<Contact> {

}

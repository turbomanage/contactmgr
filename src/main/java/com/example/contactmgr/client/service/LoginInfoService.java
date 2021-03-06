package com.example.contactmgr.client.service;

import com.example.contactmgr.shared.domain.User;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * The client side stub for the RPC service.
 */
@Path("api/user")
public interface LoginInfoService extends RestService
{
    @GET
    @Path("me")
	public void login(String requestUri, MethodCallback<User> callback);
}

package com.example.contacts.server.service.common;

import com.example.contacts.common.domain.UserSession;
import com.example.contacts.server.domain.AuthCookie;
import com.googlecode.objectify.Ref;
import com.example.contacts.common.domain.User;
import com.example.contacts.server.exception.DuplicateUserException;

public interface AppUserService
{
	Ref<User> registerUser(User u) throws DuplicateUserException;
    User getRegisteredUser(String email);
    User tryLogin(String email, String password);
    UserSession findSession(AuthCookie authCookie);
    void removeSession(UserSession userSession);
    UserSession replaceSession(User registeredUser, UserSession oldSession);
    void logout(UserSession userSession);
}

package com.example.contactmgr.server.service.common;

import com.example.contactmgr.shared.domain.User;
import com.example.contactmgr.server.domain.AuthCookie;
import com.example.contactmgr.server.domain.UserSession;
import com.example.contactmgr.server.exception.DuplicateUserException;
import com.googlecode.objectify.Ref;

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

package com.example.contactmgr.test;

import com.example.contactmgr.shared.domain.User;
import com.example.contactmgr.server.dao.UserDao;
import com.example.contactmgr.server.service.common.AppUserService;
import com.example.contactmgr.server.service.common.AppUserServiceFactory;
import com.example.contactmgr.test.helper.BaseTest;
import com.turbomanage.gwt.server.servlet.AuthFilter;

import java.util.List;

public class UserTestCase extends BaseTest
{
    User u;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        u = AuthFilter.getUser();
        AppUserService userService = AppUserServiceFactory.getAppUserService();
    }

    public void testUserAdded() throws Exception
    {
        UserDao dao = new UserDao();
        // Find users matching an email address
        List<User> users = dao.listByProperty("emailAddress", "test@example.com");
        assertEquals(1, users.size());
        assertNotNull(users.get(0).getId());
    }

    public static User addTestUser() throws Exception
    {
        // Create new user
        User u = new User();
        u.setEmailAddress("test@example.com");
        u.setFirstName("Test");
        u.setLastName("User");
        u.setGoogleId("testAccountId");
        AppUserService userService = AppUserServiceFactory.getAppUserService();
        userService.registerUser(u);
        assertNotNull(u.getId());
        return u;
    }
}

package com.example.contactmgr.app.shared.domain;

import com.googlecode.objectify.Ref;

/**
 * Created by david on 7/11/14.
 */
public interface Owned {

    public Ref<com.example.contactmgr.app.shared.domain.User> getOwnerKey();

    public void setOwnerKey(Ref<User> owner);

}

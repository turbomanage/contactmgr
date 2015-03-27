package com.example.contactmgr.common.client.presenter;

import com.example.contactmgr.common.client.ui.web.View;

/**
 * Created by Gene on 6/11/2014.
 */
public interface Presenter<V extends View> {


    public void bind(V view);

    public V getView();
}

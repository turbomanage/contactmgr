package com.example.contacts.app.client.presenter;

import com.example.contacts.common.client.presenter.Presenter;
import com.example.contacts.common.client.ui.web.View;

/**
 * Created by Gene on 6/5/2014.
 */
public class PopupPresenter<V extends View> implements Presenter<V> {

    private V view;

    @Override
    public void bind(V view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public V getView() {
        return view;
    }

//    public void start() {
//        getView().init();
//    }

}
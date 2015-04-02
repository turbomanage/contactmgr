package com.turbomanage.gwt.client;

import com.turbomanage.gwt.client.Presenter;
import com.turbomanage.gwt.client.View;

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
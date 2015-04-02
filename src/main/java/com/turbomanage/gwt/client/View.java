package com.turbomanage.gwt.client;

import com.google.gwt.user.client.ui.Widget;

/**
 * Created by Gene on 6/10/2014.
 */
public interface View<P extends Presenter> extends Display {

//    void init();
//
//    void hide();
//
//    void show();

    Widget asWidget();

    void setPresenter(P presenter);
}

package com.example.contactmgr.common.client.presenter;

import com.example.contactmgr.common.client.ui.web.View;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Base class for Activity acting as a presenter
 */
public class ActivityPresenter<V extends View> extends AbstractActivity implements Presenter<V> {

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

    @Override
    public void start(AcceptsOneWidget acceptsOneWidget, EventBus eventBus) {
        acceptsOneWidget.setWidget(getView().asWidget());
    }

}
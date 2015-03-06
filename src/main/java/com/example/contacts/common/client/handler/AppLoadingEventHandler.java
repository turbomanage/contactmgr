package com.example.contacts.common.client.handler;

import com.google.gwt.event.shared.EventHandler;

public interface AppLoadingEventHandler extends EventHandler
{

	void onAppLoadingEvent(boolean isComplete);

}

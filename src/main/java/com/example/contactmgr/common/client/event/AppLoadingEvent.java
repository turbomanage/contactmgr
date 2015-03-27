package com.example.contactmgr.common.client.event;

import com.example.contactmgr.common.client.handler.AppLoadingEventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class AppLoadingEvent extends GwtEvent<AppLoadingEventHandler>
{

	public static final GwtEvent.Type<AppLoadingEventHandler> TYPE = new GwtEvent.Type<AppLoadingEventHandler>();
	
	// Indicates whether we're starting or stopping loading
	private boolean isComplete; 

	public AppLoadingEvent(boolean isComplete)
	{
		this.isComplete = isComplete;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AppLoadingEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(AppLoadingEventHandler handler)
	{
		handler.onAppLoadingEvent(isComplete);
	}

}

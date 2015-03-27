package com.example.contactmgr.app.client.ui.widget;

import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.user.client.ui.HasValue;

import java.util.List;

public interface HasListValue extends HasValue<String>, HasValueChangeHandlers<String>
{
	List<String> getValues();
}
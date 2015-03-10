package com.turbomanage.gwt.client.ui.widget;

import com.google.gwt.user.client.ui.HasValue;

import java.util.Collection;

/**
 * MVP-friendly interface for use with any widget that can be populated
 * with a Collection of items, one of which may be selected 
 * 
 * @author David Chandler
 *
 * @param <T>
 */
public interface HasSelectedValue<T> extends HasValue<T>
{
	void setSelections(Collection<T> selections);

	void setValue(T selected, boolean fireEvents);

    void clearSelectedValue();
	
	T getValue();
}

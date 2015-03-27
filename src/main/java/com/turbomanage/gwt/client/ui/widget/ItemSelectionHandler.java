package com.turbomanage.gwt.client.ui.widget;

import com.google.gwt.event.shared.EventHandler;

import java.util.HashSet;

public interface ItemSelectionHandler<T> extends EventHandler
{
	void onItemsSelected(HashSet<T> selectedItems);
}

package com.example.contactmgr.app.client.ui.widget;

import com.example.contactmgr.common.client.ui.web.AppStyles;
import com.google.gwt.user.client.ui.Label;

public class FormLabel extends Label
{
	public FormLabel(String label)
	{
		this.setText(label);
		this.addStyleName(AppStyles.FORM_LABEL);
	}
}

package com.example.contactmgr.common.client.ui.widget;

import com.example.contactmgr.common.client.ui.web.AppStyles;
import com.google.gwt.user.client.ui.Label;

public class Heading1 extends Label
{

	public Heading1(String text)
	{
		super(text);
		this.addStyleName(AppStyles.HEADING_1);
	}

	public Heading1()
	{
		super();
		this.addStyleName(AppStyles.HEADING_1);
	}

}

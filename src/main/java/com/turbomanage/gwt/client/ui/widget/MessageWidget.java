package com.turbomanage.gwt.client.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.turbomanage.gwt.client.event.ShowMessageEvent;
import com.turbomanage.gwt.client.handler.ShowMessageHandler;

public class MessageWidget 
{
    public static final String MESSAGE_PANEL_ID = "messagePanel";

    public interface WidgetResources extends ClientBundle {
        @Source("MessageWidget.gss")
        WidgetStyles css();
    }

    public interface WidgetStyles extends CssResource {
        String msgInfo();
        String msgWarn();
    }

    private static final WidgetResources res = GWT.create(WidgetResources.class);

    private final EventBus eventBus;

    static {
        res.css().ensureInjected();
    }

	public static enum MessageType 
	{
		INFO(res.css().msgInfo()),
		WARN(res.css().msgWarn());
		
		private String styleName;

		MessageType(String styleName)
		{
			this.styleName = styleName;
		}

		public String getStyleName()
		{
			return styleName;
		}
	};
	
	private FlowPanel messageDiv = new FlowPanel();
	private Label messageText = new Label();

	public MessageWidget(EventBus bus)
	{
		this.eventBus = bus;
		
		messageText.addStyleName(res.css().msgInfo());
		messageDiv.add(messageText);
		messageDiv.getElement().setId(MESSAGE_PANEL_ID);
		
		eventBus.addHandler(ShowMessageEvent.TYPE, new ShowMessageHandler()
		{
			public void showMessage(String msg, MessageType type)
			{
				flashMessage(msg, type);
			}
		});
	}

	public void flashMessage(String msg, MessageType type)
	{
		messageText.setStyleName(type.getStyleName());
		messageText.setText(msg);
//		final Fade fade = new Fade(messageText.getElement());
//		fade.reset();
//		fade.addEffectCompletedHandler(new EffectCompletedHandler()
//		{
//			@Override
//			public void onEffectCompleted(EffectCompletedEvent event)
//			{
//				messageText.setText(null);
//				fade.remove();
//			}
//		});
//		fade.play(3000);
	}

	public Widget asWidget()
	{
		return messageDiv;
	}
}
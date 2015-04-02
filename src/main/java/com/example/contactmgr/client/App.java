package com.example.contactmgr.client;

import com.example.contactmgr.client.i18n.AppResources;
import com.example.contactmgr.client.ioc.ClientFactory;
import com.example.contactmgr.client.ioc.ServiceFactory;
import com.example.contactmgr.client.ioc.impl.ClientFactoryImpl;
import com.example.contactmgr.client.ioc.impl.ServiceFactoryImpl;
import com.example.contactmgr.client.place.AppPlaceHistoryMapper;
import com.example.contactmgr.client.model.AppModel;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;
import org.fusesource.restygwt.client.Dispatcher;
import org.fusesource.restygwt.example.client.dispatcher.DispatcherFactory;

import java.util.logging.Logger;

/**
 * Easy-to-type singleton from which we get all global resources.
 * The name is inspired by the Android Application class.
 */
public class App {

    private static final AppModel appModel = new AppModel();

    private static final ClientFactory clientFactory = new ClientFactoryImpl();
    private static final ServiceFactory serviceFactory = new ServiceFactoryImpl();
    private static final DispatcherFactory dispatcherFactory = new DispatcherFactory();

    private static final EventBus eventBus = new SimpleEventBus();
    private static final PlaceController placeController = new PlaceController(eventBus);
    private static final PlaceHistoryMapper placeHistoryMapper = GWT.create(AppPlaceHistoryMapper.class);

    private static final Logger rootLogger = Logger.getLogger("");

    private App() {
        // prevent instantiation
    }

    public static Logger getLogger() {
        return rootLogger;
    }

    public static PlaceHistoryMapper historyMapper() {
        return placeHistoryMapper;
    }

    public static EventBus eventBus() {
        return eventBus;
    }

    public static PlaceController placeController() {
        return placeController;
    }

    public static ClientFactory clientFactory() {
        return clientFactory;
    }

    public static ServiceFactory serviceFactory() {
        return serviceFactory;
    }

    public static AppModel model() {
        return appModel;
    }

    public static Dispatcher getDispatcher() {
        return dispatcherFactory.cachingDispatcher();
    }

    public static AppResources resources() {
        return AppResources.INSTANCE;
    }

}
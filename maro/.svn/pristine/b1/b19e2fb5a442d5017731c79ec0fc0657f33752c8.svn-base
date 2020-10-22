package com.maro.client.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("dgToolBar","hidden");
    }
}

package pl.sdacademy.tweeter.web;

import pl.sdacademy.tweeter.db.DatabasePopulator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DataBasePopulatingListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DatabasePopulator.populateDefaultAuthors();
    }
}

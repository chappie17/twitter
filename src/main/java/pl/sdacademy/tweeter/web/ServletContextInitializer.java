package pl.sdacademy.tweeter.web;

import pl.sdacademy.tweeter.model.Dashboard;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        registerTwitterServlet(event.getServletContext());
    }

    private void registerTwitterServlet(ServletContext context) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = factory.createEntityManager();
        Dashboard dashboard = new Dashboard(entityManager);
        context.addServlet("TweeterServlet", new TweeterServlet(dashboard)).addMapping("/tweeter");
    }
}

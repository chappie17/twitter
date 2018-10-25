package pl.sdacademy.tweeter.web;

import pl.sdacademy.tweeter.db.TwitterEntityManagerFactory;
import pl.sdacademy.tweeter.db.executor.JpaAuthorRepository;
import pl.sdacademy.tweeter.model.Dashboard;
import pl.sdacademy.tweeter.model.LoginManager;

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
        //context jest tylko jeden można wszystko do niego dodać
        EntityManager entityManager = TwitterEntityManagerFactory.entityManager();
        Dashboard dashboard = new Dashboard(entityManager);
        context.addServlet("TweeterServlet", new TweeterServlet(dashboard)).addMapping("/tweeter");

        LoginManager loginManager = new LoginManager(new JpaAuthorRepository(entityManager));
        LoginServlet loginServlet = new LoginServlet(loginManager);
        context.addServlet("LoginServlet", loginServlet).addMapping("/login");
    }
}

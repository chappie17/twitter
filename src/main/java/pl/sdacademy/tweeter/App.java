package pl.sdacademy.tweeter;

import org.apache.catalina.startup.Tomcat;
import pl.sdacademy.tweeter.model.EmbeddedTomcatFactory;

public class App {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = create();
        tomcat.start();
        tomcat.getServer().await();
    }

    private static Tomcat create() throws Exception {
        return EmbeddedTomcatFactory.create(8080);
    }
}


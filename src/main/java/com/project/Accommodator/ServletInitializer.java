package com.project.Accommodator;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Configures the Servlet container when deploying the application as a WAR file.
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * Configure the application builder with the main application class.
     * @param application The SpringApplicationBuilder object used to build the application.
     * @return The configured SpringApplicationBuilder object.
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AccomodatorApplication.class);
    }

}

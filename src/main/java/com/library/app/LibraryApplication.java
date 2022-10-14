package com.library.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "file:/opt/appdocs/test/application.properties", ignoreResourceNotFound = true)
//@PropertySource(value = "file:/opt/appdocs/test/conf/application.properties", ignoreResourceNotFound = true)

//@PropertySource(value = "file:C:\\SwipeTech\\Projects\\APPLICATION_PROPERTIES\\library\\application.properties", ignoreResourceNotFound = true)

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class})

public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}

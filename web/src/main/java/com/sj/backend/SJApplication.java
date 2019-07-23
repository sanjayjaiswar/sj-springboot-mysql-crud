package com.sj.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author Sanjay Jaiswar
 *
 * 7/23/19
 */
@SpringBootApplication
public class SJApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        new SJApplication()
                .configure(new SpringApplicationBuilder(SJApplication.class))
                        .run(args);
    }

}
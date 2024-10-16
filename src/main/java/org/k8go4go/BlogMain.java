package org.k8go4go;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogMain {
    public static void main(String[] args) {
        SpringApplication.run(BlogMain.class, args);
    }
}
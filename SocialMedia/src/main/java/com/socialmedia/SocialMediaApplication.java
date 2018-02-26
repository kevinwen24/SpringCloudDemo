package com.socialmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.socialmedia.listener.StartApplicationListener;

@SpringBootApplication
public class SocialMediaApplication {

    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(SocialMediaApplication.class);  
        app.addListeners(new StartApplicationListener());  
        app.run(args);
    }
}

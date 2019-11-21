package com.jimmy.dubbo.provide;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class ProvideApp {
    public static void main(String[] args){
        new SpringApplicationBuilder(ProvideApp.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

}

package com.example.citrus;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest()
@ContextConfiguration(classes = CitrusApplication.class, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {


    /**
     * Need this method so the cucumber will recognize this class as glue and load
     * spring context configuration
     */
    @Before
    public void setUp() {
        System.out.println("initializer");
    }

}
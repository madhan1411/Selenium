package com.seleniumbasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class SeleniumApplication extends SpringBootServletInitializer implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(SeleniumApplication.class);

    @Autowired
    WebPage webPage;


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SeleniumApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SeleniumApplication.class, args).close();
    }

    @Override
    public void run(String... strings) throws Exception {

        LOG.info("com.selenium.SeleniumApplication.run() Start....");

        webPage.init();
        webPage.openSite();
        webPage.login();


//        write additional functions
//        webPage.refresh();

//        webPage.mobileCategory();

//        webPage.back();

//        webPage.forward();

//        webPage.clickForDeal();

  //      webPage.enterInSearchBox();

 //       webPage.search();

  //      webPage.clickOnFirst();

   //     webPage.shutdown();


    }

}

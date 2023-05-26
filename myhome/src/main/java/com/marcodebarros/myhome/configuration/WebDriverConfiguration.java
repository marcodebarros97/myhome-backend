package com.marcodebarros.myhome.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class WebDriverConfiguration {

    @Bean(destroyMethod = "quit")
    @Scope("singleton")
    public WebDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver", "myhome/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
        //options.setHeadless(true);
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}

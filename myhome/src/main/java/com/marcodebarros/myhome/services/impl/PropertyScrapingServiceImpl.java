package com.marcodebarros.myhome.services.impl;

import com.marcodebarros.myhome.services.PropertyScrapingService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class PropertyScrapingServiceImpl implements PropertyScrapingService {
    private final WebDriver chromeDriver;

    @Autowired
    public PropertyScrapingServiceImpl(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    @Override
    public void navigateToPropertySourceWebsite() {
        chromeDriver.get("https://www.pararius.com/english");
            Actions actions = new Actions(chromeDriver);
            WebElement searchBox = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("autocomplete-1479055117")));
    }
}

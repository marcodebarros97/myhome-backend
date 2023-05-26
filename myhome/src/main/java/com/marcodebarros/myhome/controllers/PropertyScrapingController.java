package com.marcodebarros.myhome.controllers;


import com.marcodebarros.myhome.services.PropertyScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property-scraping")
public class PropertyScrapingController {

    @Autowired
    private PropertyScrapingService propertyScrapingService;

    @PostMapping("/scrape")
    public ResponseEntity<String> scrapeProperties(){
        propertyScrapingService.navigateToPropertySourceWebsite();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.smartosc.training.webadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping
public class ProductController {

    private final MessageSource messageSource;

    @Autowired
    public ProductController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/")
    public String getDashboardPage(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        //add messageBag here!
        return "dashboard";
    }

}

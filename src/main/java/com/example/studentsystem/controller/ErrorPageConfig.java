package com.example.studentsystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorPageConfig implements ErrorPageRegistrar {

    private static final Logger logger = LoggerFactory.getLogger(ErrorPageConfig.class);

    @Override
    public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
        //1、Distinguish by error type
        //404 Not Found
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        //500 Internal Server Error
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
        errorPageRegistry.addErrorPages(e404, e500);
    }

}

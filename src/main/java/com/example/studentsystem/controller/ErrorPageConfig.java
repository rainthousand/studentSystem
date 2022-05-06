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

        //500 Internal Server Error
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
        //503 Service Unavailable
        ErrorPage e503 = new ErrorPage(HttpStatus.SERVICE_UNAVAILABLE, "/error/503");
        //400 Bad Request
        ErrorPage e400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400");
        //401 Unauthorized
        ErrorPage e401 = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401");
        //403 Forbidden
        ErrorPage e403 = new ErrorPage(HttpStatus.FORBIDDEN, "/error/403");
        //404 Not Found
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        //405 Method Not Allowed
        ErrorPage e405 = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/error/405");


        errorPageRegistry.addErrorPages(e404, e500);
    }

}

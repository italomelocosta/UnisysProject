/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novo.unisys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Italo
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Ocorrência de SQLException")
    @ExceptionHandler(SQLException.class)
    public void handleSQLException(HttpServletRequest request, Exception ex){
        logger.info("SQLException handler executed in : " + request.getRequestURL().toString());
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Ocorrência de NullPointerException")
    @ExceptionHandler(NullPointerException.class)
    public void NullPointerExceptionException(HttpServletRequest request, Exception ex){
        logger.error("NullPointerException handler executed in : " + request.getRequestURL().toString());
    }
}

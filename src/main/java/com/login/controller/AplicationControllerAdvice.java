package com.login.controller;

import com.login.errors.Errors;
import com.login.errors.exceptions.RegraNegocioException;
import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AplicationControllerAdvice {

  @ExceptionHandler(RegraNegocioException.class)
  @ResponseStatus(BAD_REQUEST)
  public Errors handleRegraNegocioException(RegraNegocioException regraNegocioException){
    String message = regraNegocioException.getMessage();
    return new Errors(message);
  }
}

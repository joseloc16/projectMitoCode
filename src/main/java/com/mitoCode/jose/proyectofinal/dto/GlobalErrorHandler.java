package com.mitoCode.jose.proyectofinal.dto;

import com.mitoCode.jose.proyectofinal.exceptions.ModelNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDto> handleExceptions(Exception ex, WebRequest request) {
    ErrorDto dto = new ErrorDto(
        LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ModelNotFoundException.class)
  public ResponseEntity<ErrorDto> handleModelNotFound(
      ModelNotFoundException ex, WebRequest request) {
    ErrorDto dto = new ErrorDto(
        LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    return super.handleMethodArgumentNotValid(ex, headers, status, request);
  }
}
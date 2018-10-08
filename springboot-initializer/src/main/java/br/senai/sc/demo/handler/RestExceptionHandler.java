package br.senai.sc.demo.handler;

import br.senai.sc.demo.endpoint.error.ErrorDetails;
import br.senai.sc.demo.endpoint.error.ResourceNotFoundDetails;
import br.senai.sc.demo.endpoint.error.ResourceNotFoundException;
import br.senai.sc.demo.endpoint.error.ValidationErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException){
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
                .newBuilder()
                .timesstamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .titile("Resource not Found")
                .detail(rfnException.getClass().getName())
                .developerMessage(rfnException.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetails,HttpStatus.NOT_FOUND);
    }

@Override
public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException,
                                                          HttpHeaders headers,
                                                          HttpStatus status,
                                                          WebRequest request) {
        List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();
        System.out.println(fieldErrors);

        ValidationErrorDetails rnfDetails = ValidationErrorDetails.Builder
                .newBuilder()
                .timesstamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .titile("Resource not Found")
                .detail(manvException.getClass().getName())
                .developerMessage(manvException.getClass().getName())
                .build();
        return new ResponseEntity<>(manvException,HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.Builder
                .newBuilder()
                .timesstamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .titile("Resource not ssssssssFound")
                .detail(ex.getClass().getName())
                .developerMessage(ex.getClass().getName())
                .build();
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

}

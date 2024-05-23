package ir.mostafa.semnani.springsecuritymodule.security.exception.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.mostafa.semnani.springsecuritymodule.security.exception.common.ExceptionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {

            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        ExceptionDetails exceptionDetails = null;
        try {
            exceptionDetails = new ExceptionDetails(sdf.format(new Date()),
                    "please check the fields",
                    objectMapper.writeValueAsString(errors));
        } catch (JsonProcessingException e) {
            log.error("error in ValidationHandler", e);
            ExceptionDetails ed = new ExceptionDetails(sdf.format(new Date()),
                    "internal server error",
                    "");

            return new ResponseEntity<>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

}

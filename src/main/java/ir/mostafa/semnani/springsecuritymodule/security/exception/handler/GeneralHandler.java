package ir.mostafa.semnani.springsecuritymodule.security.exception.handler;

import ir.mostafa.semnani.springsecuritymodule.security.exception.common.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class GeneralHandler {
    @ExceptionHandler({BadCredentialsException.class, UsernameNotFoundException.class})
    public ResponseEntity<ExceptionDetails> handleBadCredentialsException() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        return new ResponseEntity<>(
                new ExceptionDetails(
                        sdf.format(new Date()),
                        "username or password is wrong",
                        ""
                )
                , HttpStatus.UNAUTHORIZED);
    }

}

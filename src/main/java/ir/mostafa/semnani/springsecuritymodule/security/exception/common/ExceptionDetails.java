package ir.mostafa.semnani.springsecuritymodule.security.exception.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDetails {
    private String timestamp;
    private String message;
    private String details;
}

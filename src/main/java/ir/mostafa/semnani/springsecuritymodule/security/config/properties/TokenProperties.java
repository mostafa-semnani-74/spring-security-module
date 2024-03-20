package ir.mostafa.semnani.springsecuritymodule.security.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "token")
@Getter
@Setter
public class TokenProperties {
    private Long timeToLive;
}

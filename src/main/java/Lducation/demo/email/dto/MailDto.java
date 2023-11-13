package Lducation.demo.email.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Setter
@Getter
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "secret")
public class MailDto {
    private String address;
    private String title;
    private String message;

}

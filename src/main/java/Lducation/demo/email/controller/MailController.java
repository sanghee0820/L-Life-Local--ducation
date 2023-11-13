package Lducation.demo.email.controller;

import Lducation.demo.applicationForm.dto.ApplicationFormDto;
import Lducation.demo.applicationForm.service.ApplicationFormService;
import Lducation.demo.email.dto.MailDto;
import Lducation.demo.email.service.MailService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@AllArgsConstructor
public class MailController {
    private final MailService mailService;
    private final ApplicationFormService applicationFormService;

    @PostMapping("/mail")
    public void exexMail(@RequestBody ApplicationFormDto applicationFormDto) throws MessagingException, IOException, URISyntaxException {

        String filepath = applicationFormService.AddTextToPdf(applicationFormDto);
        mailService.mailSend(applicationFormDto,filepath);
    }

}

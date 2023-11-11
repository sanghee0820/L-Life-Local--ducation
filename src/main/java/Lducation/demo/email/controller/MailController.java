package Lducation.demo.email.controller;

import Lducation.demo.email.dto.MailDto;
import Lducation.demo.email.service.MailService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@AllArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping("/mail")
    public void exexMail(MailDto mailDto) throws MessagingException, IOException {

        mailService.mailSend(mailDto);
    }
}

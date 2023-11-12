package Lducation.demo.email.service;


import Lducation.demo.applicationForm.dto.ApplicationFormDto;
import Lducation.demo.email.dto.MailDto;
import com.sun.mail.util.logging.MailHandler;
import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@AllArgsConstructor
public class MailService {
    private JavaMailSender javaMailSender;
    public static final String FROM_ADDRESS = "dragon6619@naver.com";

    public void mailSend(ApplicationFormDto applicationFormDto) throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();

        File file = new ClassPathResource("static/appform4 _saving.pdf").getFile();
        FileDataSource fds = new FileDataSource(file);

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true, "UTF-8");

        mimeMessageHelper.setTo("lsh277604@gmail.com");
        mimeMessageHelper.setSubject(applicationFormDto.getCoursename());
        mimeMessageHelper.setText("강좌 신청서 입니다.", true);
        mimeMessageHelper.addAttachment("appform4 _saving.pdf",fds);
        message.setFrom(MailService.FROM_ADDRESS);

        javaMailSender.send(message);
    }

}

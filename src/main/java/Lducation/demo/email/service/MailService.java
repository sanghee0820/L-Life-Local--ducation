package Lducation.demo.email.service;


import Lducation.demo.applicationForm.dto.ApplicationFormDto;
import Lducation.demo.email.dto.MailDto;
import com.sun.mail.util.logging.MailHandler;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MailService {
    private JavaMailSender javaMailSender;
    public static final String FROM_ADDRESS = "dragon6619@naver.com";

    public void mailSend(ApplicationFormDto applicationFormDto) throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();

        Module module = getClass().getModule();
        InputStream inputStream = module.getResourceAsStream("static/appform4 _saving.pdf");

//        File file = new ClassPathResource("static/appform4 _saving.pdf").getFile();
//        FileDataSource fds = new FileDataSource(file);
//        FileDataSource fds2 = new FileDataSource(inputStream.toString());

        InputStreamSource inputStreamSource = new InputStreamResource(inputStream);

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true, "UTF-8");

        mimeMessageHelper.setTo("lsh277604@gmail.com");
        mimeMessageHelper.setSubject(applicationFormDto.getCoursename());
        mimeMessageHelper.setText("강좌 신청서 입니다.", true);
//        mimeMessageHelper.addAttachment("appform4 _saving.pdf",fds);
//        mimeMessageHelper.addAttachment("appform4 _saving.pdf",inputStreamSource);
        message.setFrom(MailService.FROM_ADDRESS);

        DataSource dataSource = new ByteArrayDataSource(inputStream, "application/pdf");
        mimeMessageHelper.addAttachment("appform4_saving.pdf", dataSource);


        inputStream.close();

        javaMailSender.send(message);
    }

}

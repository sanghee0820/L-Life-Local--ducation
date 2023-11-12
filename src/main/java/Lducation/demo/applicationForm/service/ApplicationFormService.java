package Lducation.demo.applicationForm.service;

import Lducation.demo.applicationForm.dto.ApplicationFormDto;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationFormService {
    public void AddTextToPdf(ApplicationFormDto applicationFormDto) throws IOException {
        File file = new ClassPathResource("static/appform4.pdf").getFile();
        PDDocument document = PDDocument.load(file);

        PDPage page = document.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(document, page,
                PDPageContentStream.AppendMode.APPEND, true);
        contentStream.beginText();

        PDFont font = PDType0Font.load(document,
                new ClassPathResource("static/Apple_산돌고딕_Neo/AppleSDGothicNeoT.ttf").getFile());
        contentStream.setFont(font, 10);

        contentStream.newLineAtOffset(173, 718);
        String name = applicationFormDto.getName();
        contentStream.showText(name);

        contentStream.newLineAtOffset(0, -20);
        String birthday = applicationFormDto.getBirthday();
        contentStream.showText(birthday);

        contentStream.setFont(font, 8);
        contentStream.newLineAtOffset(0, -34);
        String phone = applicationFormDto.getPhone();
        contentStream.showText(phone);

        contentStream.newLineAtOffset(0, -23);
        String address = applicationFormDto.getAddress();
        contentStream.showText(address);

        contentStream.newLineAtOffset(0, -15);
        String addressDetail = applicationFormDto.getAddress_detail();
        contentStream.showText(addressDetail);

        contentStream.setFont(font, 5);
        String sex = applicationFormDto.getSex();
        if (sex.equals("male")) {
            contentStream.newLineAtOffset((float) -2.8, 57);
        } else {
            contentStream.newLineAtOffset((float) 18, 57);
        }
        String dot = "●";
        contentStream.showText(dot);

        contentStream.endText();
        contentStream.fill();
        contentStream.stroke();

        contentStream.close();

        document.save(new File("/Users/gwondoyun/Desktop/hackerton/L-ducation/src/main/resources/static/new.pdf"));

        document.close();

    }

    public String DateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }
}

package Lducation.demo.applicationForm.service;

import Lducation.demo.applicationForm.dto.ApplicationFormDto;
import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationFormService {
    public void AddTextToPdf(ApplicationFormDto applicationFormDto) throws IOException {
        File file = new ClassPathResource("static/appForm.pdf").getFile();
        PDDocument document = PDDocument.load(file);

        PDPage page = document.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);
        contentStream.beginText();

        contentStream.setFont(PDType1Font.TIMES_ROMAN, 16);

        List<String> textList = new ArrayList<String>();
        textList.add(applicationFormDto.getName());
        textList.add(applicationFormDto.getBirthday());
        textList.add(applicationFormDto.getSex());
        textList.add(applicationFormDto.getPhone());
        textList.add(applicationFormDto.getAddress());

        for(int i=0;i<5;i++){
            contentStream.newLineAtOffset(100,100*i);
            String text = textList.get(i);

            contentStream.showText(text);
        }

        contentStream.endText();

        contentStream.close();

        document.save(new File("/Users/gwondoyun/Desktop/hackerton/L-ducation/src/main/resources/static/new.pdf"));

        document.close();

    }

    public String DateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }
}

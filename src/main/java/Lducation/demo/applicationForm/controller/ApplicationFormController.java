package Lducation.demo.applicationForm.controller;

import Lducation.demo.applicationForm.dto.ApplicationFormDto;
import Lducation.demo.applicationForm.service.ApplicationFormService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class ApplicationFormController {
    private final ApplicationFormService applicationFormService;

    @PostMapping("/app")
    public ResponseEntity<?> addTextInPdf(@RequestBody ApplicationFormDto applicationFormDto) throws IOException {

        applicationFormService.AddTextToPdf(applicationFormDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }



}

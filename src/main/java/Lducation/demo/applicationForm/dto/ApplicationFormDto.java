package Lducation.demo.applicationForm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class ApplicationFormDto {
    private String name;
    private String birthday;
    private String sex;
    private String phone;
    private String address;
    private String address_detail;
    private String coursename;

}

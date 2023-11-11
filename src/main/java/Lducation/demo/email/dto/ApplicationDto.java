package Lducation.demo.email.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationDto {
    private String name;
    private String sex;
    private Date birthday;
    private String phone;
    private String address;

}

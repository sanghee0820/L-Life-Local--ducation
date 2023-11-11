package Lducation.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String gu;
    private String courseName;
    private String instructorName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String courseContent;

    @Enumerated(EnumType.STRING)
    private Day operatingDays;
    private String location;
    private int capacity;
    private String operatingAgency;
    private String operatingAgencyPhoneNumber;
    private LocalDate registrationStartDate;
    private LocalDate registrationEndDate;

}

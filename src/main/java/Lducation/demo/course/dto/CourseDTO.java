package Lducation.demo.course.dto;

import Lducation.demo.course.domain.Course;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class CourseDTO {
    private Long id;
    private String gu;
    private String courseName;
    private String instructorName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String courseContent;
    private String operatingDays;
    private String location;
    private int capacity;
    private String operatingAgency;
    private String operatingAgencyPhoneNumber;
    private LocalDate registrationStartDate;
    private LocalDate registrationEndDate;

    public static CourseDTO toDTO(Course course) {
        return CourseDTO.builder()
                .id(course.getId())
                .gu(course.getGu())
                .courseName(course.getCourseName())
                .instructorName(course.getInstructorName())
                .startDate(course.getStartDate())
                .endDate(course.getEndDate())
                .startTime(course.getStartTime())
                .endTime(course.getEndTime())
                .courseContent(course.getCourseContent())
                .operatingDays(course.getOperatingDays().getDesc())
                .location(course.getLocation())
                .capacity(course.getCapacity())
                .operatingAgency(course.getOperatingAgency())
                .operatingAgencyPhoneNumber(course.getOperatingAgencyPhoneNumber())
                .registrationEndDate(course.getRegistrationEndDate())
                .registrationStartDate(course.getRegistrationStartDate())
                .build();
    }
}

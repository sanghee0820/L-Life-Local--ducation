package Lducation.demo.service;

import Lducation.demo.domain.Course;
import Lducation.demo.domain.Day;
import Lducation.demo.repository.CourseRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getCourseInfo(String gu) {

        List<Course> courses = courseRepository.findByGu(gu);
        courses.add(new Course(
                1L,
                "test",
                "test",
                "test",
                LocalDate.now(),
                LocalDate.now().plusDays(7),
                LocalTime.of(9, 0),
                LocalTime.of(17, 0),
                "Test Content",
                Day.MONDAY,
                "Test Location",
                20,
                "Test Agency",
                "123-456-7890",
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        ));
        log.info(String.valueOf(courses.isEmpty()));
        return courses;
    }
}

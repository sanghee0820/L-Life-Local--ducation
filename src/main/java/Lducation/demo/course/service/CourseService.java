package Lducation.demo.course.service;

import Lducation.demo.course.domain.Course;
import Lducation.demo.course.dto.CourseDTO;
import Lducation.demo.course.repository.CourseRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<CourseDTO> getCourseInfo(String gu) {

        List<Course> courses = courseRepository.findByGu(gu);
        List<CourseDTO> courseDTOs = courses.stream()
                .map(CourseDTO::toDTO)
                .collect(Collectors.toList());
        log.info(String.valueOf(courses.isEmpty()));
        return courseDTOs;
    }
}

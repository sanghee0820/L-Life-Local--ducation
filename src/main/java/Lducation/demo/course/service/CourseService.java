package Lducation.demo.course.service;

import Lducation.demo.course.domain.Course;
import Lducation.demo.course.dto.CourseDTO;
import Lducation.demo.course.dto.PageDTO;
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

    public PageDTO getCourseInfoByGu(String gu, Long page) {
        List<Course> courses = courseRepository.findByGu(gu);
        log.info(String.valueOf(courses.size()));
        int pageSize = 9;
        if (validPageSize(page, (long) (courses.size() / 9))) {
            return null;
        }
        int startIndex = Math.toIntExact(page * pageSize);
        int endIndex = Math.min(Math.toIntExact((page + 1) * pageSize), courses.size());

        List<CourseDTO> courseDTOs = splitCourses(courses, startIndex, endIndex);

        PageDTO pageDTO = PageDTO.builder()
                .page(page)
                .maxPage(Long.valueOf(courses.size() / pageSize))
                .courses(courseDTOs)
                .build();
        return pageDTO;
    }

    public List<CourseDTO> getCourseInfoAll() {

        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOs = courses.stream()
                .map(CourseDTO::toDTO)
                .collect(Collectors.toList());
        log.info(String.valueOf(courses.isEmpty()));
        return courseDTOs;
    }

    private boolean validPageSize(Long page, Long maxPage) {
        if (page < 0 || page > maxPage) {
            return true;
        }
        return false;
    }

    private List<CourseDTO> splitCourses(List<Course> courses, int startIndex, int endIndex) {
        return courses.subList(startIndex, endIndex)
                .stream()
                .map(CourseDTO::toDTO)
                .collect(Collectors.toList());
    }
}

package Lducation.demo.controller;

import Lducation.demo.domain.Course;
import Lducation.demo.service.CourseService;
import Lducation.demo.service.KakaoMapService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InfoController {
    private final KakaoMapService googleMapService;
    private final CourseService courseService;

    @GetMapping("/info")
    public ResponseEntity<List<Course>> getPosition(
            @RequestParam(value = "x") final String latitude,
            @RequestParam(value = "y") final String longitude) {

        List<Course> courseInfo =
                courseService.getCourseInfo(googleMapService.getPosition(latitude, longitude));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(courseInfo);
    }
}

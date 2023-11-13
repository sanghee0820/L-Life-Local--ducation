package Lducation.demo.course.controller;

import Lducation.demo.course.dto.PageDTO;
import Lducation.demo.course.service.CourseService;
import Lducation.demo.course.service.KakaoMapService;
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
    private final KakaoMapService kakaoMapService;
    private final CourseService courseService;

    @GetMapping("/position")
    public ResponseEntity<String> getPosition(
            @RequestParam(value = "latitude", required = false) final String latitude,
            @RequestParam(value = "longitude", required = false) final String longitude) {

        log.info(latitude + " " + longitude);
        String position = kakaoMapService.getPosition(latitude, longitude);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(position);
    }

    @GetMapping("/info")
    public ResponseEntity<PageDTO> getCourse(
            @RequestParam(value = "gu", required = true) final String gu,
            @RequestParam(value = "page", required = true) final Long page) {
        
        PageDTO pageInfo = courseService.getCourseInfoByGu(gu, page);
        if (pageInfo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pageInfo);
    }
}

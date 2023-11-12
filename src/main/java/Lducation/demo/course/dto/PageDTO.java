package Lducation.demo.course.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PageDTO {
    private Long page;
    private Long maxPage;
    private List<CourseDTO> courses;

}

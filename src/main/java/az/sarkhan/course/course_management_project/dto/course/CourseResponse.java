package az.sarkhan.course.course_management_project.dto.course;

import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {

    private Long id;
    private String nameOfCourse;
    private int price;
    private Set<String> students;
}

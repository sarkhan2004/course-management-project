package az.sarkhan.course.course_management_project.dto.course;

import lombok.Data;

@Data
public class CourseRequest {
    private String courseName;
    private double coursePrice;
}

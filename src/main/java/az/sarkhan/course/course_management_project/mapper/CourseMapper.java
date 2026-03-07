package az.sarkhan.course.course_management_project.mapper;

import az.sarkhan.course.course_management_project.dto.course.CourseRequest;
import az.sarkhan.course.course_management_project.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course toEntity(CourseRequest request) {
        return new Course(
                request.getNameOfCourse(),
                request.getPrice()
        );
    }
}

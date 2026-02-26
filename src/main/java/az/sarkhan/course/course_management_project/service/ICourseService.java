package az.sarkhan.course.course_management_project.service;

import az.sarkhan.course.course_management_project.entity.Course;

import java.util.List;

public interface ICourseService {
    Course createCourse(Course course);

    void deleteCourse(Long id);

    List<Course> getAllCourses();

    Course getCourseById(Long id);


}

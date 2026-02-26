package az.sarkhan.course.course_management_project.service;

import az.sarkhan.course.course_management_project.entity.Course;
import az.sarkhan.course.course_management_project.entity.Student;
import az.sarkhan.course.course_management_project.exception.CourseNotFoundException;
import az.sarkhan.course.course_management_project.exception.StudentNotFoundException;
import az.sarkhan.course.course_management_project.repository.CourseRepository;
import az.sarkhan.course.course_management_project.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found"));

        courseRepository.delete(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found"));
    }



}

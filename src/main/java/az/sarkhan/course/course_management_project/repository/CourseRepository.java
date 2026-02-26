package az.sarkhan.course.course_management_project.repository;

import az.sarkhan.course.course_management_project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}

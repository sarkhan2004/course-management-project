package az.sarkhan.course.course_management_project.service;

import az.sarkhan.course.course_management_project.entity.Student;

import java.util.List;

public interface IStudentService {
    Student createStudent(Student student);

    void deleteStudent(Long id);

    void enrollStudent(Long studentId, Long courseId);

    void removeCourseFromStudent(Long studentId, Long courseId);

    Student findStudentById(Long studentId);

    List<Student> getAllStudents();
}

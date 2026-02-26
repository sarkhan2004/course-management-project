package az.sarkhan.course.course_management_project.service;

import az.sarkhan.course.course_management_project.entity.Course;
import az.sarkhan.course.course_management_project.entity.Student;
import az.sarkhan.course.course_management_project.exception.CourseNotFoundException;
import az.sarkhan.course.course_management_project.exception.StudentNotFoundException;
import az.sarkhan.course.course_management_project.repository.CourseRepository;
import az.sarkhan.course.course_management_project.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
       Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

       studentRepository.delete(student);
    }

    @Override
    public void enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found"));

        student.addCourse(course);
        studentRepository.save(student);
    }

    @Override
    public void removeCourseFromStudent(Long studentId, Long courseId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found"));

        student.removeCourse(course);

        studentRepository.save(student);
    }

    @Override
    public Student findStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

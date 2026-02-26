package az.sarkhan.course.course_management_project.mapper;

import az.sarkhan.course.course_management_project.dto.student.StudentRequest;
import az.sarkhan.course.course_management_project.dto.student.StudentResponse;
import az.sarkhan.course.course_management_project.entity.Student;
import az.sarkhan.course.course_management_project.repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequest request) {
        return new Student(
                request.getStudentFirstName(),
                request.getStudentLastName(),
                request.getStudentAge()
        );
    }

    public StudentResponse toResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setStudentFirstName(student.getStudentFirstName());
        response.setStudentLastName(student.getStudentLastName());
        response.setStudentAge(student.getStudentAge());

        //Set Course to Set String
        response.setCourses(
                student.getCourses().stream()
                        .map(course -> course.getNameOfCourse())
                        .collect(Collectors.toSet())
        );

        return response;
    }

}

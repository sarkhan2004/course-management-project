package az.sarkhan.course.course_management_project.mapper;

import az.sarkhan.course.course_management_project.dto.student.StudentRequest;
import az.sarkhan.course.course_management_project.dto.student.StudentResponse;
import az.sarkhan.course.course_management_project.entity.Student;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequest request) {
        return new Student(
                request.getFirstName(),
                request.getLastName(),
                request.getAge()
        );
    }

    public StudentResponse toResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setAge(student.getAge());

        //Set Course to Set String
        response.setCourses(
                student.getCourses().stream()
                        .map(course -> course.getNameOfCourse())
                        .collect(Collectors.toSet())
        );

        return response;
    }

}

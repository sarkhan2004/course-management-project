package az.sarkhan.course.course_management_project.dto.student;

import java.util.Set;

import lombok.Data;

@Data
public class StudentResponse {

    private Long id;
    private String  firstName;
    private String lastName;
    private int age;
    private Set<String> courses;

}

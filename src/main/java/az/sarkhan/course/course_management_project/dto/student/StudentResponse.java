package az.sarkhan.course.course_management_project.dto.student;

import java.util.Set;

import lombok.Data;

@Data
public class StudentResponse {

    private Long id;
    private String  studentFirstName;
    private String studentLastName;
    private int studentAge;
    private Set<String> courses;

}

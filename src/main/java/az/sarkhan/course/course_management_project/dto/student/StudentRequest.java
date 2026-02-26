package az.sarkhan.course.course_management_project.dto.student;

import lombok.Data;

@Data
public class StudentRequest {

    private String studentFirstName;
    private String studentLastName;
    private int studentAge;
}

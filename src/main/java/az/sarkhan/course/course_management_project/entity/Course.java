package az.sarkhan.course.course_management_project.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameOfCourse;
    private int price;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}

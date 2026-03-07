package az.sarkhan.course.course_management_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NonNull
    private String nameOfCourse;

    @NonNull
    private int price;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();


    public void addStudent(Student student) {
        this.students.add(student);
        student.getCourses().add(this);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
        student.getCourses().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return id != null && id.equals(course.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode(); // стабильный hashCode, не зависит от id
    }
}

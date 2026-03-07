package az.sarkhan.course.course_management_project.controller;

import az.sarkhan.course.course_management_project.dto.student.StudentRequest;
import az.sarkhan.course.course_management_project.dto.student.StudentResponse;
import az.sarkhan.course.course_management_project.entity.Student;
import az.sarkhan.course.course_management_project.mapper.StudentMapper;
import az.sarkhan.course.course_management_project.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    public StudentResponse create(@RequestBody StudentRequest request) {
        Student student = studentService.createStudent(
                studentMapper.toEntity(request)
        );

        return studentMapper.toResponse(student);
    }

    @GetMapping("/{id}")
    public StudentResponse getById(@PathVariable Long id) {
        Student student = studentService.findStudentById(id);

        return studentMapper.toResponse(student);
    }

    @GetMapping
    public List<StudentResponse> getAll() {

        return studentService.getAllStudents()
                .stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}


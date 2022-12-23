package miu.edu.CourseRegistration1.controller;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.Student;
import miu.edu.CourseRegistration1.entity.Users;
import miu.edu.CourseRegistration1.rabbitMQ.service.RabbitService;
import miu.edu.CourseRegistration1.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    StudentService studentService;

    RabbitService rabbitService;

    @PostMapping("")
    public String createStudent(@RequestBody Student s){
        studentService.createStudent(s);
        Users u = new Users();
        u.setRole("student");
        u.setEmail(s.getEmail());
        u.setPassword(s.getPassword());
        u.setId(s.getId());
        return "student successfully created";
    }

    @GetMapping("/{id}")
    public Student findStudentByStudentId(@PathVariable Long id){
        return studentService.findStudentByStudentId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id){
        Student s = studentService.findStudentByStudentId(id);
        rabbitService.sendMessage("delete "+ id);
        studentService.deleteStudentById(id);
        return "successfully deleted student with id: " + s.getStudentID();
    }

    @GetMapping("")
    public List<Student> findStudents(){
        return studentService.findAllStudents();
    }
}
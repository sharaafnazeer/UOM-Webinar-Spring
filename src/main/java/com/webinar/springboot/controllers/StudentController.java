package com.webinar.springboot.controllers;

import com.webinar.springboot.model.Student;
import com.webinar.springboot.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudentById(id);

        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {

        Student savedStudent = studentService.saveStudent(student);
        if (savedStudent != null) {
            return new ResponseEntity<>("Saved Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Saved Successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") int id,
                                                @RequestBody Student student) {

        Student exStudent = studentService.getStudentById(id);
        if (exStudent != null) {
//            student.setId(id);
            student.setId(exStudent.getId());
            Student savedStudent = studentService.saveStudent(student);

            if (savedStudent != null) {
                return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Not Updated Successfully", HttpStatus.OK);
            }

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
        Student exStudent = studentService.getStudentById(id);
        if (exStudent != null) {
            boolean deleted = studentService.deleteStudent(exStudent.getId());
            if (deleted) {
                return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Not Deleted Successfully", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

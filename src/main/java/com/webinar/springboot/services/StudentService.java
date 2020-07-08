package com.webinar.springboot.services;

import com.webinar.springboot.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(int studentId);

    Student saveStudent(Student student);

    boolean deleteStudent(int studentId);
}

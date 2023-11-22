package com.kharzixen.schooladministrationrestapi.controller;

import com.kharzixen.schooladministrationrestapi.dto.incomming.StudentDtoIn;
import com.kharzixen.schooladministrationrestapi.dto.outgoing.StudentDtoOut;
import com.kharzixen.schooladministrationrestapi.model.Student;
import com.kharzixen.schooladministrationrestapi.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/api/students")
    public ResponseEntity<StudentDtoOut> createStudent(@RequestBody StudentDtoIn studentDtoIn){
        return new ResponseEntity<>(studentService.createStudent(studentDtoIn), HttpStatus.CREATED);
    }

    @GetMapping("/api/students")
    public ResponseEntity<List<StudentDtoOut>> getAllStudents(){
        return new ResponseEntity<>(studentService.getALlStudents(), HttpStatus.OK);
    }
}

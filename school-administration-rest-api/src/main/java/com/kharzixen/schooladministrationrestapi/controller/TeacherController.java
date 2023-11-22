package com.kharzixen.schooladministrationrestapi.controller;

import com.kharzixen.schooladministrationrestapi.dto.incomming.StudentDtoIn;
import com.kharzixen.schooladministrationrestapi.dto.incomming.TeacherDtoIn;
import com.kharzixen.schooladministrationrestapi.dto.outgoing.StudentDtoOut;
import com.kharzixen.schooladministrationrestapi.dto.outgoing.TeacherDtoOut;
import com.kharzixen.schooladministrationrestapi.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/api/teachers")
    public ResponseEntity<TeacherDtoOut> createTeacher(@RequestBody TeacherDtoIn teacherDtoIn){
        return new ResponseEntity<>(teacherService.createTeacher(teacherDtoIn), HttpStatus.CREATED);
    }

    @GetMapping("/api/teachers")
    public ResponseEntity<List<TeacherDtoOut>> getAllTeachers(){
        return new ResponseEntity<>(teacherService.getALlTeachers(), HttpStatus.OK);
    }
}

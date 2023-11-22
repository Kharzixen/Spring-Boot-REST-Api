package com.kharzixen.schooladministrationrestapi.service;

import com.kharzixen.schooladministrationrestapi.dto.incomming.StudentDtoIn;
import com.kharzixen.schooladministrationrestapi.dto.outgoing.StudentDtoOut;
import com.kharzixen.schooladministrationrestapi.mapper.StudentMapper;
import com.kharzixen.schooladministrationrestapi.model.Student;
import com.kharzixen.schooladministrationrestapi.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public StudentDtoOut createStudent(StudentDtoIn studentDtoIn) {
        Student student = StudentMapper.INSTANCE.dtoToModel(studentDtoIn);
        student.setCourses(new ArrayList<>());
        student.setIdentifierFirstPart(getIdentifierFirstPart(student).toLowerCase());
        Student saved = studentRepository.saveAndFlush(student);
        saved.setIdentifierFirstPart(saved.getIdentifierFirstPart().concat(saved.getId().toString()));
        saved = studentRepository.saveAndFlush(saved);
        return StudentMapper.INSTANCE.modelToDto(saved);
    }

    public List<StudentDtoOut> getALlStudents(){
        return studentRepository.findAll().stream().map(StudentMapper.INSTANCE::modelToDto).toList();
    }

    private static String getIdentifierFirstPart(Student student) {
        String departmentCode = "";
        String[] depAndLanguage = student.getDepartment().split("-");
        String[] departmentParts = depAndLanguage[0].split("_");
        for (String part : departmentParts) {
            departmentCode = departmentCode.concat(part.substring(0, 1));
        }

        return student.getFirstName().charAt(0) +
                student.getLastName().charAt(0) +
                departmentCode +
                depAndLanguage[1].charAt(0);
    }
}

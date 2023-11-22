package com.kharzixen.schooladministrationrestapi.service;

import com.kharzixen.schooladministrationrestapi.dto.incomming.TeacherDtoIn;
import com.kharzixen.schooladministrationrestapi.dto.outgoing.StudentDtoOut;
import com.kharzixen.schooladministrationrestapi.dto.outgoing.TeacherDtoOut;
import com.kharzixen.schooladministrationrestapi.mapper.TeacherMapper;
import com.kharzixen.schooladministrationrestapi.model.Student;
import com.kharzixen.schooladministrationrestapi.model.Teacher;
import com.kharzixen.schooladministrationrestapi.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Transactional
    public TeacherDtoOut createTeacher(TeacherDtoIn teacherDtoIn) {
        Teacher teacher = TeacherMapper.INSTANCE.dtoToModel(teacherDtoIn);
        teacher.setCourses(new ArrayList<>());
        teacher.setIdentifierFirstPart(getIdentifierFirstPart(teacher).toLowerCase());
        Teacher saved = teacherRepository.saveAndFlush(teacher);
        saved.setIdentifierFirstPart(saved.getIdentifierFirstPart().concat(saved.getId().toString()));
        saved = teacherRepository.saveAndFlush(saved);
        return TeacherMapper.INSTANCE.modelToDto(saved);
    }

    public List<TeacherDtoOut> getALlTeachers() {
        return teacherRepository.findAll().stream().map(TeacherMapper.INSTANCE::modelToDto).toList();
    }

    private static String getIdentifierFirstPart(Teacher teacher) {
        String departmentCode = "";
        String[] depAndLanguage = teacher.getDepartment().split("-");
        String[] departmentParts = depAndLanguage[0].split("_");
        for (String part : departmentParts) {
            departmentCode = departmentCode.concat(part.substring(0, 1));
        }

        return teacher.getFirstName().substring(0,1) +
                teacher.getLastName().substring(0,1) +
                departmentCode +
                depAndLanguage[1].charAt(0)
                +"_"
                +teacher.getRole_short();
    }
}

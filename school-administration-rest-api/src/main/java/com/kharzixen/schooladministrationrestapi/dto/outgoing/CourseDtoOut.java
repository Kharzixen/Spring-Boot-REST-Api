package com.kharzixen.schooladministrationrestapi.dto.outgoing;

import com.kharzixen.schooladministrationrestapi.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDtoOut {
    private Long id;

    private String identifierFirstPart;
    private String name;
    private int nrOfCredits;

    //Document Syllabus;

    private List<TeacherDtoOutWithoutCourses> teachers = new ArrayList<>();
    private List<StudentDtoOutWithoutCourses> students = new ArrayList<>();
}

package com.kharzixen.schooladministrationrestapi.dto.outgoing;

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
public class TeacherDtoOut {
    private Long id;

    private String firstName;
    private String lastName;
    private String externalEmail;
    private String internalEmail;
    private String department;
    private String identifierFirstPart;
    private String role;
    private String role_short;


    List<CourseDtoOut> courses = new ArrayList<>();
}

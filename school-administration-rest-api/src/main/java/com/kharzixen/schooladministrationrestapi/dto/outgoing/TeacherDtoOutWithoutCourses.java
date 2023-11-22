package com.kharzixen.schooladministrationrestapi.dto.outgoing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDtoOutWithoutCourses {
    private Long id;

    private String firstName;
    private String lastName;
    private String externalEmail;
    private String internalEmail;
    private String department;
    private String identifierFirstPart;

}

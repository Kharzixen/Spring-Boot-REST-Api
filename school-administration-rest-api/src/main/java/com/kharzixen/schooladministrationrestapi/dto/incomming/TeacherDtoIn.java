package com.kharzixen.schooladministrationrestapi.dto.incomming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDtoIn {
    protected String firstName;
    protected String lastName;
    protected String externalEmail;
    protected String internalEmail;
    protected String department;
    protected String identifierFirstPart;
    private String role;
    private String role_short;
}

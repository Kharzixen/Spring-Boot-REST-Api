package com.kharzixen.schooladministrationrestapi.dto.incomming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDtoIn {
    protected String firstName;
    protected String lastName;
    protected String externalEmail;
    protected String internalEmail;
    protected String department;
}

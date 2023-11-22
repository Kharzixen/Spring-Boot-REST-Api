package com.kharzixen.schooladministrationrestapi.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Person {
    @Id
    @SequenceGenerator(name = "EntityTwoSequence", initialValue = 1000)
    @GeneratedValue(generator = "EntityTwoSequence")
    protected Long id;

    protected String firstName;
    protected String lastName;
    protected String externalEmail;
    protected String internalEmail;
    protected String department;
    protected String identifierFirstPart;
}

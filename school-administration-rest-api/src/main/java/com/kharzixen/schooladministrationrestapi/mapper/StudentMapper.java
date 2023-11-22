package com.kharzixen.schooladministrationrestapi.mapper;

import com.kharzixen.schooladministrationrestapi.dto.incomming.StudentDtoIn;
import com.kharzixen.schooladministrationrestapi.dto.outgoing.StudentDtoOut;
import com.kharzixen.schooladministrationrestapi.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    public StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDtoOut modelToDto(Student student);
    Student dtoToModel(StudentDtoIn studentDtoIn);

    List<StudentDtoOut> modelsToDtos(List<Student> students);


}

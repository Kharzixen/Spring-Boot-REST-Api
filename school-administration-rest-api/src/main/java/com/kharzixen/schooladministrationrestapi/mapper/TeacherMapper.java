package com.kharzixen.schooladministrationrestapi.mapper;

import com.kharzixen.schooladministrationrestapi.dto.incomming.TeacherDtoIn;
import com.kharzixen.schooladministrationrestapi.dto.outgoing.TeacherDtoOut;
import com.kharzixen.schooladministrationrestapi.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    public TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDtoOut modelToDto(Teacher teacher);

    Teacher dtoToModel(TeacherDtoIn teacherDtoIn) ;

    List<TeacherDtoOut> modelsToDtos(List<Teacher> teachers);

}

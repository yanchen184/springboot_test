package com.example.test.mapper;


import com.example.test.data.ColorCustomResponseData;
import com.example.test.model.projector.ColorData;
import org.mapstruct.BeanMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CartonMapper extends ListMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "codeAndNameZh", source = "codeAndZhName")
    @Mapping(target = "codeAndNameEn", source = "codeAndEnName")
    ColorCustomResponseData toCmsCartonChangeToToteIssueResponseData(ColorData source);

}


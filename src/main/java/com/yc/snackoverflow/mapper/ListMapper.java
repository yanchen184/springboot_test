package com.yc.snackoverflow.mapper;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Context;
import org.mapstruct.Named;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface ListMapper {

    @Named("splitToList")
    default List<String> splitToList(String str, @Context String delimiter) {
        return Optional.ofNullable(str)
                .filter(StringUtils::isNotEmpty)
                .map(s -> s.split(delimiter))
                .map(Arrays::asList)
                .orElseGet(List::of);
    }
}

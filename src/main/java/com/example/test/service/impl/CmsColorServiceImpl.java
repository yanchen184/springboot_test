package com.example.test.service.impl;


import com.example.test.color.ColorCustomResponseData;
import com.example.test.color.ColorData;
import com.example.test.data.ColorDto;
import com.example.test.mapper.CartonMapper;
import com.example.test.model.Color;
import com.example.test.reposity.CmsColorDao;
import com.example.test.service.CmsColorService;
import com.example.test.color.CmsColorMainResponseData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CmsColorServiceImpl implements CmsColorService {

    @Autowired
    private CmsColorDao cmsColorDao;

    @Autowired
    private CartonMapper cartonMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CmsColorMainResponseData> getAllColor() {
        List<Color> list = cmsColorDao.findAll();
        return list.stream().map(this::entityToResponseData).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ColorCustomResponseData> getColor() {
        List<ColorData> colorDataList = cmsColorDao.findColor();
        return colorDataList.stream().map(cartonMapper::toCmsCartonChangeToToteIssueResponseData).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Color> getColors() {
        List<Color> list = cmsColorDao.findAll();
        return list.stream().collect(Collectors.toMap(Color::getCode, Function.identity()));
    }

    @Override
    public void saveColor(ColorDto colorDto) {
        Color color = new Color(colorDto.getName(), colorDto.getNameZh(), colorDto.getNameEn());
        cmsColorDao.save(color);
    }

    private CmsColorMainResponseData entityToResponseData(Color color) {
        return CmsColorMainResponseData.builder().code(color.getCode()).enName(color.getEnName()).zhName(color.getZhName()).build();
    }
}

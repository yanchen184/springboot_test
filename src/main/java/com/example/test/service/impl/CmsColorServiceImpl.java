package com.example.test.service.impl;


import com.example.test.data.ColorCustomResponseData;
import com.example.test.model.projector.ColorData;
import com.example.test.data.ColorRequestData;
import com.example.test.mapper.CartonMapper;
import com.example.test.model.Color;
import com.example.test.reposity.CmsColorDao;
import com.example.test.service.CmsColorService;
import com.example.test.data.ColorResponseData;
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
    public List<ColorResponseData> getAllColor() {
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
    public void saveColor(ColorRequestData colorRequestData) {
        Color color = new Color(colorRequestData.getName(), colorRequestData.getNameZh(), colorRequestData.getNameEn());
        cmsColorDao.save(color);
    }

    private ColorResponseData entityToResponseData(Color color) {
        return ColorResponseData.builder().code(color.getCode()).enName(color.getEnName()).zhName(color.getZhName()).build();
    }
}

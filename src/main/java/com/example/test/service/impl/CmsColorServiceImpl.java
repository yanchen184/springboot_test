package com.example.test.service.impl;


import com.example.test.model.Color;
import com.example.test.reposity.CmsColorDao;
import com.example.test.service.CmsColorService;
import data.color.CmsColorMainResponseData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CmsColorServiceImpl implements CmsColorService {

    private final CmsColorDao cmsColorDao;

    @Override
    @Transactional(readOnly = true)
    public List<CmsColorMainResponseData> getAllColor() {
//        List<Color> list = cmsColorDao.findAll();
//        return list.stream()
//                .map(this::entityToResponseData)
//                .collect(Collectors.toList());
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Color> getColors() {
//        List<Color> list = cmsColorDao.findAll();
//        return list.stream()
//                .collect(Collectors.toMap(Color::getCode, Function.identity()));
        return null;
    }

    private CmsColorMainResponseData entityToResponseData(Color color) {
        return CmsColorMainResponseData.builder().code(color.getCode()).enName(color.getEnName()).zhName(color.getZhName()).build();
    }
}

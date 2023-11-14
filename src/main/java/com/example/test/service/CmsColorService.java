package com.example.test.service;


import com.example.test.data.ColorDto;
import com.example.test.model.Color;
import com.example.test.color.CmsColorMainResponseData;

import java.util.List;
import java.util.Map;

public interface CmsColorService {
    List<CmsColorMainResponseData> getAllColor();

    Map<String, Color> getColors();

    void saveColor(ColorDto colorDto);
}

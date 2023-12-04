package com.example.test.service;


import com.example.test.data.ColorCustomResponseData;
import com.example.test.data.ColorRequestData;
import com.example.test.model.Color;
import com.example.test.data.ColorResponseData;

import java.util.List;
import java.util.Map;

public interface CmsColorService {
    List<ColorResponseData> getAllColor();

    Map<String, Color> getColors();

    List<ColorCustomResponseData> getColor();

    void saveColor(ColorRequestData colorRequestData);
}

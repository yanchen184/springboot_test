package com.example.test.reposity;

import com.example.test.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CmsColorDao extends JpaRepository<Color, Long> {

}

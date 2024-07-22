package com.yc.snackoverflow.service.impl;

import com.yc.snackoverflow.data.ProductDto;
import com.yc.snackoverflow.enums.UpsertStatusEnum;
import com.yc.snackoverflow.exception.WebErrorEnum;
import com.yc.snackoverflow.model.Product;
import com.yc.snackoverflow.reposity.ProductDao;
import com.yc.snackoverflow.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Override
    @Transactional
    public UpsertStatusEnum createOrUpdate(ProductDto productDto) {
        Product product = Product.builder()
                .name(productDto.getName())
                .picture(productDto.getPicture())
                .price(productDto.getPrice())
                .build();
        int createOrUpdate = productDao.saveOrUpdate(product);

        log.info("memberDao.saveOrUpdateMember(product) return {}", UpsertStatusEnum.lookup(createOrUpdate));
        return UpsertStatusEnum.lookup(createOrUpdate)
                .orElseThrow(WebErrorEnum.UPSERT_FAILED::exception);
    }

    @Override
    public List<Product> list(List<String> productNameList) {
        return Optional.ofNullable(productDao.list(productNameList))
                .filter(members -> !members.isEmpty())
                .orElseThrow(WebErrorEnum.PRODUCT_NOT_FOUND::exception);
    }

}
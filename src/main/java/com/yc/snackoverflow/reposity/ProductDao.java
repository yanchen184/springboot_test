package com.yc.snackoverflow.reposity;

import com.yc.snackoverflow.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

    @Modifying
    @Query(value = "INSERT INTO PRODUCT (NAME, PRICE, PICTURE) VALUES (:name, :price, :picture )" +
            " ON DUPLICATE KEY UPDATE NAME = :name, PRICE = :price, PICTURE = :picture", nativeQuery = true)
    int saveOrUpdate(String name, int price, String picture);

    default int saveOrUpdate(Product product) {
        return saveOrUpdate(product.getName(), product.getPrice(), product.getPicture());
    }

    @Query(value = "SELECT * FROM Product WHERE (:productNameList IS NULL OR NAME IN (:productNameList))", nativeQuery = true)
    List<Product> list(List<String> productNameList);
}

package com.ezen.product01.Repository;

import com.ezen.product01.Entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Override
    List<ProductEntity> findAll();


   // ArrayList<ProductEntity> findAllById(Long id);


    @Override
    void deleteById(Long id);


    @Transactional
    @Modifying
    @Query(value = "update product set readcnt = readcnt +1 where product.id = :id", nativeQuery = true )
    int updateReadcnt(@Param("id") Long id);
}

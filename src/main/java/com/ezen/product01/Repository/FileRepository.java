package com.ezen.product01.Repository;

import com.ezen.product01.Entity.FileEntity;
import com.ezen.product01.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    @Override
    List<FileEntity> findAll();
}

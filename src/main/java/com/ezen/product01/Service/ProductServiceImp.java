package com.ezen.product01.Service;

import com.ezen.product01.Entity.ProductEntity;
import com.ezen.product01.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository pRepository;

    @Override
    public void in(ProductEntity pEntity1) {
        pRepository.save(pEntity1);
    }

    /*
    @Override
    public ArrayList<ProductEntity> out(Long id) {
        return pRepository.findAllById(id);
    }
    */

    @Override
    public List<ProductEntity> out() {
        return pRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }


    @Override
    public Page<ProductEntity> list(Pageable pageable) {
        return pRepository.findAll(pageable);
    }

    @Override
    public Page<ProductEntity> SearchList(String searchKeyword, Pageable pageable) {
        return null;
    }


    @Override
    public void delete(Long id) {
        pRepository.deleteById(id);
    }

    @Override
    public ProductEntity modify(Long id) {
        return pRepository.findById(id).orElse(null);
    }

    @Override
    public void mod(ProductEntity pEntity3) {
        pRepository.findById(pEntity3.getId()).orElse(null);
        if (pEntity3 != null) {
            pRepository.save(pEntity3);
        }
    }

    @Override
    public ProductEntity detail(Long id) {
        return pRepository.findById(id).orElse(null);
    }

    @Override
    public int updateReadcnt(Long id) {
        return pRepository.updateReadcnt(id);
    }




}

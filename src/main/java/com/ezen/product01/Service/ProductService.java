package com.ezen.product01.Service;

import com.ezen.product01.Entity.ProductEntity;

import java.util.List;

public interface ProductService {
    public void in(ProductEntity pEntity1);

  // public ArrayList<ProductEntity> out(Long id);
    public List<ProductEntity> out();

    public void delete(Long id);

    public ProductEntity modify(Long id);

    public void mod(ProductEntity pEntity3);

  ProductEntity detail(Long id);

  public int updateReadcnt(Long id);
}

package com.ezen.product01.mapper;

import com.ezen.product01.DTO.Product;
import com.ezen.product01.Entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public interface ServiceMapper {
    List<ProductEntity> search(String keyword);
    /*
    public void in(String pname, String pimg, String pd, String pft, int price);

    public ArrayList<Market> out();

    public void del(String pname);

    public Market mod_select(String pname);

    public void mod_save(String pname, String pimg, String pd, String pft, int price);

    public Market detail(String pname);
    */

}

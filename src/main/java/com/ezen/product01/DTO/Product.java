package com.ezen.product01.DTO;

import com.ezen.product01.Entity.ProductEntity;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Product {
    Long id;

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    String name;
    
    @Max(message = "숫자 100까지 가능", value = 100)
    @Min(message = "최소 숫자 1부터 시작", value = 1)
    @NotNull(message = "개수는 필수 입력값")
    int count;

    @Max(message = "숫자 10억까지 가능", value = 1000000000)
    @Min(message = "최소 숫자 10부터 시작", value = 10)
    @NotNull(message = "가격은 필수 입력값")
    int price;

    int cost;

    String market;
    String category;

    int readcnt;

    LocalDate writeday;

    public ProductEntity toEntity() {
        return new ProductEntity(id, name, count, price, cost, market, category, readcnt, writeday);
    }


}

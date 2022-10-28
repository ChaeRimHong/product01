package com.ezen.product01.Entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
@Table(name = "product")
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(
        name = "product_seq_generator",
        sequenceName = "product_seq",
        initialValue = 1, allocationSize = 1)

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_seq_generator")
    Long id;

    @Column
    String name;

    @Column
    int count;

    @Column
    int price;

    @Column
    int cost;

    @Column
    String market;

    @Column
    String category;

    @Column
    int readcnt;

    @Column
    LocalDate writeday;
}

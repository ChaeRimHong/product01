package com.ezen.product01.Entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
@Table(name = "file01")
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(
        name = "fileid_seq_generator",
        sequenceName = "fileid_seq",
        initialValue = 1, allocationSize = 1)

public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "fileid_seq_generator")
    Long fileid;

    @Column
    String storefilename;

    @Column
    String uploadfilename;

}

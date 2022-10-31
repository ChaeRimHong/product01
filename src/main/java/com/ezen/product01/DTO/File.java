package com.ezen.product01.DTO;

import com.ezen.product01.Entity.FileEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class File {
    Long fileid;
    String storefilename;
    String uploadfilename;
    public FileEntity toEntity()
    {
        return new FileEntity(fileid, storefilename,uploadfilename);
    }
}

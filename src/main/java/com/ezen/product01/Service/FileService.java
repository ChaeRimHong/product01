package com.ezen.product01.Service;

import com.ezen.product01.Entity.FileEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    public void in(FileEntity fEntity1);

   // Page<FileEntity> list(int page);

    //List<FileEntity> out();

    List<FileEntity> file_out();
}

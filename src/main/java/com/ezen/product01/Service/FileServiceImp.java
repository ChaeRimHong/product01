package com.ezen.product01.Service;

import com.ezen.product01.Entity.FileEntity;
import com.ezen.product01.Repository.FileRepository;
import com.ezen.product01.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileServiceImp implements FileService {
    @Autowired
    FileRepository fRepository;

    @Override

    public void in(FileEntity fEntity1) {
        fRepository.save(fEntity1);
    }

    @Override
    public List<FileEntity> file_out() {
        return fRepository.findAll();
    }


}

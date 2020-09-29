package com.tianling.house.biz.service;

import com.google.common.collect.Lists;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianling
 * @create 2020/9/16
 **/
public interface FileService {
    public List<String> getImagePath(List<MultipartFile> files);
}

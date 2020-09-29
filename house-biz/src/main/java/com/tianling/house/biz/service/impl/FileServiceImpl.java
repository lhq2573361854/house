package com.tianling.house.biz.service.impl;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.tianling.house.biz.service.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianling
 * @create 2020/9/16
 **/
@Service("FileService")
public class FileServiceImpl implements FileService {

    @Value("${file.path}")
    private String filePath;

    /**
     * 获取保存在服务器上的url
     * @param files
     * @return
     */

    @Override
    public List<String> getImagePath(List<MultipartFile> files) {
        ArrayList<String> paths = Lists.newArrayList();

        files.forEach(file ->{
            File localFile = null;
            if (file != null) {
                try {
                    localFile = saveToFile(file,filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String s = StringUtils.substringAfterLast(localFile.getAbsolutePath(), filePath);
                paths.add(s);
            }
        });
        return paths;
    }

    /**
     * 文件上传到服务器
     * @param file
     * @param filePath
     * @return
     * @throws IOException
     */
    private File saveToFile(MultipartFile file, String filePath) throws IOException {
        File newFile = new File(filePath + "/" + Instant.now().getEpochSecond() + "/" + file.getOriginalFilename());
        if(!newFile.exists()){
            newFile.getParentFile().mkdirs();
            newFile.createNewFile();
        }
        Files.write(file.getBytes(), newFile);
        return newFile;
    }
}

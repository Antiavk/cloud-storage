package com.cloudstorage.storage.services;

import com.cloudstorage.storage.models.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StorageService {

    public String saveFile(String authToken, MultipartFile file);

    public boolean updateFile(String authToken, String oldFilename, String newFilename);

    public boolean deleteFile(String authToken, String filename);

    public List<File> getFileList(String authToken, int limit);

    public byte[] getFile(String authToken, String filename);
}

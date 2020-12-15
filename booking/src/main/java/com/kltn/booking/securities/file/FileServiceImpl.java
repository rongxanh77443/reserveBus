package com.kltn.booking.securities.file;

import com.kltn.booking.configs.FileStorageProperties;
import com.kltn.booking.exceptions.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 1:47 PM
 * Filename  : FileServiceImpl
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService{

    public FileServiceImpl(FileStorageProperties fileStorageProperties) {
        try {
            Path fileUploadStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
            if (Files.notExists(fileUploadStorageLocation)) {
                Files.createDirectories(fileUploadStorageLocation);
            }
        } catch (Exception ex) {
            throw new ServerException("Lỗi khi khởi tạo thư mục uploads");
        }
        try {
            Path fileDownloadStorageLocation = Paths.get(fileStorageProperties.getDownloadDir()).toAbsolutePath().normalize();
            if (Files.notExists(fileDownloadStorageLocation)) {
                Files.createDirectories(fileDownloadStorageLocation);
            }
        } catch (Exception ex) {
            throw new ServerException("Lỗi khi khởi tạo thư mục downloads");
        }
    }
}

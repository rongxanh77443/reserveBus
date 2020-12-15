package com.kltn.booking.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 12:58 PM
 * Filename  : FileStorageProperties
 */
@Getter
@Setter
@Configuration
public class FileStorageProperties {
    @Value("${file.upload_dir}")
    private String uploadDir;

    @Value("${file.download_dir}")
    private String downloadDir;

}

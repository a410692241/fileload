package com.wei.fileload;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FdfsClientConfig.class)
public class FileloadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileloadApplication.class, args);
    }
}

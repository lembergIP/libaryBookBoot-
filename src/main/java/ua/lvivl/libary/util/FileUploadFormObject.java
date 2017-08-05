package ua.lvivl.libary.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


public class FileUploadFormObject {
    @Getter
    @Setter
    private MultipartFile file;
}

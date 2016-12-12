package ua.lvivl.libary.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by lembergIP on 11.11.2016.
 */
public class FileUploadFormObject {
    @Getter
    @Setter
    private MultipartFile file;
}

package ua.lvivl.libary.util;


import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


/**
 * load default book image
 */
public class ImagesHolderUtil {
    private static byte[] defaultPictureBook = {};
    static private Logger logger=Logger.getLogger(ImagesHolderUtil.class);

    static {
        File imgEmptyBook = new File("src/main/webapp/resources/images/books/empty.png");

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream(1000)) {

            BufferedImage bufferedImage = ImageIO.read(imgEmptyBook);
            ImageIO.write(bufferedImage, "jpg", baos);
            baos.flush();
            defaultPictureBook = baos.toByteArray();

        } catch(IOException ioe) {
            logger.error("Default image load problem :  "+ioe);
        }
    }

    private ImagesHolderUtil(){}

    public static byte[] getDefaultPictureBook() {
        return defaultPictureBook;
    }

}

package resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 14:04
 */
public class newFileCopyTest {

    @Test
    public void copyFile() {
        String originalUrl = "originaldir/FileCopyTest.java";
        String targetUrl = "targetdir/file.txt";

        try (
                FileInputStream fis = new FileInputStream(originalUrl);
                FileOutputStream fos = new FileOutputStream(targetUrl);
        ){
            int content;

            while ((content = fis.read()) != -1) {
                fos.write(content);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

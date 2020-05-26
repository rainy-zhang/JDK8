package resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 13:53
 */
public class FileCopyTest {

    @Test
    public void copyFile() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        String originalUrl = "originaldir/FileCopyTest.java";
        String targetUrl = "targetdir/FileCopyTest.txt";

        try {
            fis = new FileInputStream(originalUrl);
            fos = new FileOutputStream(targetUrl);

            int content;
            while ((content = fis.read()) != -1) {
                fos.write(content);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

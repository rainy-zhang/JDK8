package lombok;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 23:09
 */
public class CleanUpTest {

    //@CleanUp 能帮我们生成对资源进行关闭的代码
    public void copyFile(String inPath, String outPath) throws IOException {
        @Cleanup FileInputStream fis = new FileInputStream(inPath);
        @Cleanup FileOutputStream fos = new FileOutputStream(outPath);

        int content;

        while ((content = fis.read()) != -1) {
            fos.write(content);
        }
    }

}

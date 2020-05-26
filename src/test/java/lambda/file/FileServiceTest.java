package lambda.file;

import org.junit.Test;

import java.io.IOException;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 16:43
 */
public class FileServiceTest {

    @Test
    public void fileHandle() throws IOException {
        FileService.fileHandle("D:\\Programme\\Tools\\Idea\\Workspace\\996\\src\\main\\java\\lambda\\file\\FileService.java",
                fileContent -> System.out.println(fileContent));
    }

}

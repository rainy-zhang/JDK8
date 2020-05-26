package lambda.file;

import java.io.*;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 16:33
 */
public class FileService {

    public static void fileHandle(String url, FileConsumer fileConsumer) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url)));
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        fileConsumer.fileHandler(sb.toString());
    }

}
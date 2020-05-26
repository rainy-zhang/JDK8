package lambda.file;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 16:33
 */
@FunctionalInterface
public interface FileConsumer {

    void fileHandler(String content);
}

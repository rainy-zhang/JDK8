package stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 20:59
 */
public class StreamConstructor {

    /**
     * 通过数值的方式构建流
     */
    @Test
    public void streamFromValue() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
    }

    /**
     * 通过数组的方式构建流
     */
    @Test
    public void streamFromArray() {
        int[] array = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(array);
        stream.forEach(System.out::println);
    }

    /**
     * 通过文件构建流
     */
    @Test
    public void streamFromFile() throws IOException {
        Stream<String> stream = Files.lines(Paths.get("D:\\Programme\\Tools\\Idea\\Workspace\\996\\src\\test\\java\\stream\\StreamConstructor.java"));
        stream.forEach(System.out::println);
    }

    /**
     * 通过函数构建流
     */
    @Test
    public void streamFromFunction() {
//        通过迭代的方式生成无限流
//        Stream<Integer> stream = Stream.iterate(0, n -> n += 1);

//        通过生成器生成流
        Stream<Double> stream = Stream.generate(Math::random);
        stream.forEach(System.out::println);
    }

}

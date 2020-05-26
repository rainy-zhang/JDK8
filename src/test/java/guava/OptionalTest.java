package guava;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 14:13
 */
public class OptionalTest {

    @Test
    public void test() throws Throwable {
        // 创建一个空的optional对象
        Optional.empty();

        // 创建一个非空的optional对象
        Optional.of("zhangsan");

        // 可以接收Null或者非Null的值
        Optional optional = Optional.ofNullable("zhangsan");

        // 判断是否为空 (不推荐使用)
        optional.isPresent();

        // 当optional不为空时执行参数中的方法
        optional.ifPresent(System.out::println);

        // 当optional引用为空时, 返回一个默认值
        optional.orElse("lisi");
        // 自定义返回值
        optional.orElseGet(() -> {
            return "自定义引用缺失";
        });
        // 当optional为空时, 抛出异常
        optional.orElseThrow(() -> {
           throw new RuntimeException("xxxx");
        });
    }


    public static void stream(List<String> list) {
//        list.stream().forEach(System.out::println);
        // 使用optional避免空指针
        Optional.ofNullable(list)
                .map(List::stream)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        stream(null);
    }

}

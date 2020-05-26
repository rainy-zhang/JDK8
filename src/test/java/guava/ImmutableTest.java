package guava;

import com.google.common.collect.ImmutableList;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 21:41
 */
public class ImmutableTest {


    public static void remove(List list) {
        list.remove(0);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 将集合封装为一个不可变集合
        List<Integer> newList = Collections.unmodifiableList(list);
        remove(newList);
    }

    /**
     * 不可变集合不支持 添加 / 删除 / 清空 等操作
     */
    public void immutable() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 通过list构建不可变集合
        ImmutableList<Integer> list1 = ImmutableList.copyOf(list);

        // 通过数值构建不可变集合
        ImmutableList<Integer> list2 = ImmutableList.of(1, 2, 3, 4);

        // 通过build方式构建不可变集合
        ImmutableList<Object> list3 = ImmutableList.builder()
                .add(0)
                .addAll(list)
                .build();

    }


}

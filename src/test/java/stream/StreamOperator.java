package stream;

import com.alibaba.fastjson.JSON;
import lambda.cart.CartService;
import lambda.cart.Sku;
import lambda.cart.SkuCategoryEnum;
import org.junit.Test;

import java.util.*;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 17:01
 */
public class StreamOperator {

    List<Sku> list = CartService.getCartSkuList();

    /**
     * filter: 过滤掉不符合断言的元素
     */
    @Test
    public void filterTest() {
        // 过滤掉除Books类型之外的商品
        list.stream()
                .filter(sku -> SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * map: 将一个元素转换成另一个元素
     */
    @Test
    public void mapTest() {
        list.stream()
                .map(sku -> sku.getSkuName())
                .forEach(sku -> System.out.println("sku = " + sku));
    }


    /**
     * flatMap: 将一个对象转换成流
     */
    @Test
    public void flatMapTest() {
        list.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(sku -> System.out.println("sku = " + sku));

    }


    /**
     * peek: 遍历元素
     */
    @Test
    public void peekTest() {
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * sorted: 排序(默认是升序)
     */
    @Test
    public void sortedTest() {
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * distinct: 去重
     */
    @Test
    public void distinctTest() {
        list.stream()
                .map(Sku::getSkuCategory)
                .distinct()
                .forEach(sku -> System.out.println(sku));
    }


    /**
     * skip: 跳过元素
     */
    @Test
    public void skipTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));

    }

    /**
     * limit: 截断
     */
    @Test
    public void limitTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .limit(3)
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    // 终端操作

    /**
     * allMathch: 判断所有的元素是否都符合条件, 短路操作(当发现了不满足条件的元素, 就不再判断后面的元素了)
     */
    @Test
    public void allMatchTest() {
        boolean match = list.stream()
                .allMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println(match);
    }

    /**
     * anyMatch: 集合中的任意一个元素符合条件, 就返回true, 短路操作
     */
    @Test
    public void anyMatchTest() {
        boolean match = list.stream()
                .anyMatch(sku -> sku.getTotalPrice() > 100);
        System.out.println(match);
    }

    /**
     * noneMatch: 没有符合条件的元素返回true
     */
    @Test
    public void noneMatchTest() {
        boolean match = list.stream()
                .noneMatch(sku -> sku.getTotalPrice() > 10000);
        System.out.println(match);
    }

    /**
     * findFirst: 返回第一个元素
     */
    @Test
    public void findFirstTest() {
        Optional<Sku> first = list.stream()
                .findFirst();
        System.out.println(first.get());
    }

    /**
     * findAny: 返回任意一个
     */
    @Test
    public void findAnyTest() {
        Optional<Sku> any = list.stream()
                .findAny();
        System.out.println(any.get());
    }

    /**
     * max: 返回最大值
     */
    @Test
    public void maxTest() {
        OptionalDouble max = list.stream()
                .mapToDouble(sku -> sku.getTotalPrice())
                .max();
        System.out.println(max.getAsDouble());
    }

    /**
     * min: 返回最小值
     */
    @Test
    public void minTest() {
        OptionalDouble min = list.stream()
                .mapToDouble(Sku::getTotalPrice)
                .min();
        System.out.println(min.getAsDouble());
    }

    /**
     * count: 返回所有元素的个数
     */
    @Test
    public void countTest() {
        long count = list.stream()
                .count();
        System.out.println(count);
    }

}

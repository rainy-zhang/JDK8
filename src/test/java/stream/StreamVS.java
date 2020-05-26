package stream;

import com.alibaba.fastjson.JSON;
import lambda.cart.CartService;
import lambda.cart.Sku;
import lambda.cart.SkuCategoryEnum;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 13:27
 */
public class StreamVS {

    @Test
    public void StreamCartHandle() {
        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.00));
        List<String> result = CartService.getCartSkuList().stream()
                // 打印商品信息
                .peek((Sku sku) -> System.out.println(JSON.toJSONString(sku, true)))
                // 过滤掉图书类商品
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                // 根据价格进行排序, reversed: 降序
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                // 获取前两个商品信息
                .limit(2)
                // 累加商品的总金额
                .peek(sku -> money.set(sku.getTotalPrice() + money.get()))
                // 获取商品名称
                .map(sku -> sku.getSkuName())
                // 收集结果
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(result, true));
        System.out.println("商品总价格: " + money.get());

    }

}

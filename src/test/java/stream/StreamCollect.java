package stream;

import com.alibaba.fastjson.JSON;
import lambda.cart.CartService;
import lambda.cart.Sku;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 21:13
 */
public class StreamCollect {

    List<Sku> list = CartService.getCartSkuList();

    /**
     * 将结果收集为集合
     */
    @Test
    public void toList() {
        List<Sku> list = this.list.stream()
                .filter(sku -> sku.getTotalPrice() > 1000)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list, true));

    }

    /**
     * 分组
     */
    @Test
    public void groupTest() {
        Map<Enum, List<Sku>> map = list.stream()
                .collect(Collectors.groupingBy(Sku::getSkuCategory));
        System.out.println(JSON.toJSONString(map, true));
    }

    /**
     * 分区
     */
    @Test
    public void partitionTest() {
        Map<Boolean, List<Sku>> map = list.stream()
                .collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 100));
        System.out.println(JSON.toJSONString(map, true));
    }

}

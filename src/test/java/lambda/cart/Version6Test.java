package lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class Version6Test {

    @Test
    public void filterSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 过滤商品总价大于2000的商品
        List<Sku> result = CartService.filterSkus(cartSkuList, (Sku sku) -> sku.getTotalPrice() > 2000);
        List<Sku> result2 = CartService.filterSkus(cartSkuList, (Sku sku) -> SkuCategoryEnum.CLOTHING.equals(sku.getSkuCategory()));

        System.out.println(JSON.toJSONString(
                result2, true));
    }

}

package lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class Version3Test {

    @Test
    public void filterSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 根据商品总价过滤超过2000元的商品列表
        List<Sku> result = CartService.filterSkus(
                cartSkuList, SkuCategoryEnum.BOOKS,
                2000.00, true);

        System.out.println(JSON.toJSONString(
                result, true));
    }

}

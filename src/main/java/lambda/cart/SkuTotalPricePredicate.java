package lambda.cart;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 12:52
 */
public class SkuTotalPricePredicate implements SkuPredicate {

    @Override
    public Boolean check(Sku sku) {
        return sku.getTotalPrice() > 2000;
    }
}

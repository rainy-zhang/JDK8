package lambda.cart;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 12:53
 */
public class SkuBooksPredicate implements SkuPredicate {

    @Override
    public Boolean check(Sku sku) {
        return SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory());
    }
}

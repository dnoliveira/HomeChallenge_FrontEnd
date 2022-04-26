package br.com.nexmuv.homechallenge_frontend.service.promotion;

import br.com.nexmuv.homechallenge_frontend.models.CheckoutProduct;
import br.com.nexmuv.homechallenge_frontend.models.Promotion;

import java.math.BigDecimal;

public class PromotionExecBuyxGetyFree implements PromotionExec{

    @Override
    public BigDecimal exec(CheckoutProduct checkoutProduct, Promotion promotion) {
        BigDecimal promoValue = new BigDecimal(0.0);

        int qty = checkoutProduct.getQty();
        int requireQty = promotion.getRequired_qty();



        return null;
    }
}

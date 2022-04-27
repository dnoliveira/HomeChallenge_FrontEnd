package br.com.nexmuv.homechallenge_frontend.service.promotion;

import br.com.nexmuv.homechallenge_frontend.models.CheckoutProduct;
import br.com.nexmuv.homechallenge_frontend.models.Promotion;

import java.math.BigDecimal;

public class PromotionExecuteBuyxGetyFree implements PromotionExecute {

    @Override
    public BigDecimal execute(CheckoutProduct checkoutProduct) {
        BigDecimal promoValue = new BigDecimal(0.0);

        Promotion promotion = checkoutProduct.getPromotion();
        int qty = checkoutProduct.getQty();
        int requireQty = promotion.getRequired_qty();
        int freeQty = promotion.getFree_qty();

        int qtdPricePromo = qty/(requireQty+freeQty);

        if (qtdPricePromo > 0) {
            BigDecimal priceProduct = checkoutProduct.getProduct().getPrice();
            BigDecimal times = new BigDecimal(qtdPricePromo);
            promoValue = priceProduct.multiply(times);
        }

        return promoValue;
    }
}

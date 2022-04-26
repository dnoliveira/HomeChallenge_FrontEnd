package br.com.nexmuv.homechallenge_frontend.service.promotion;

import br.com.nexmuv.homechallenge_frontend.models.CheckoutProduct;
import br.com.nexmuv.homechallenge_frontend.models.Promotion;

import java.math.BigDecimal;

public class PromotionExecQtyPriceOverride implements PromotionExec{

    @Override
    public BigDecimal exec(CheckoutProduct checkoutProduct, Promotion promotion) {
        return null;
    }
}

package br.com.nexmuv.homechallenge_frontend.service.promotion;

import br.com.nexmuv.homechallenge_frontend.models.Checkout;
import br.com.nexmuv.homechallenge_frontend.models.CheckoutProduct;
import br.com.nexmuv.homechallenge_frontend.models.Promotion;

import java.math.BigDecimal;

public interface PromotionExec {

    public BigDecimal exec(CheckoutProduct checkoutProduct, Promotion promotion);
}

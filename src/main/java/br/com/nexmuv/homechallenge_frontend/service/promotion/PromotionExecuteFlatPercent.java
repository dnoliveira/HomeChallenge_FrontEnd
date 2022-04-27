package br.com.nexmuv.homechallenge_frontend.service.promotion;

import br.com.nexmuv.homechallenge_frontend.models.CheckoutProduct;
import br.com.nexmuv.homechallenge_frontend.models.Promotion;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PromotionExecuteFlatPercent implements PromotionExecute {

    @Override
    public BigDecimal execute(CheckoutProduct checkoutProduct) {
        BigDecimal promoValue = new BigDecimal(0.0);

        Promotion promotion = checkoutProduct.getPromotion();

        int qty = checkoutProduct.getQty();
        BigDecimal amountPercent = promotion.getAmount();

        if (amountPercent != null &&
            checkoutProduct.getProduct() != null &&
            checkoutProduct.getProduct().getPrice() != null)
        {
            MathContext mathContext = new MathContext(2, RoundingMode.FLOOR);
            amountPercent = amountPercent.divide(new BigDecimal(100.0));
            BigDecimal valorTotal = checkoutProduct.getProduct().getPrice().multiply(new BigDecimal(qty), mathContext);
            promoValue = valorTotal.multiply(amountPercent);
        }

        return promoValue;
    }
}

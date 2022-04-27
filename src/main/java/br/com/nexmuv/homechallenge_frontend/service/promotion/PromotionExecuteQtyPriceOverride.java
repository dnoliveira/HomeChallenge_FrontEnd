package br.com.nexmuv.homechallenge_frontend.service.promotion;

import br.com.nexmuv.homechallenge_frontend.models.CheckoutProduct;
import br.com.nexmuv.homechallenge_frontend.models.Promotion;

import java.math.BigDecimal;

public class PromotionExecuteQtyPriceOverride implements PromotionExecute {

    @Override
    public BigDecimal execute(CheckoutProduct checkoutProduct) {
        BigDecimal promoValue = new BigDecimal(0.0);

        Promotion promotion = checkoutProduct.getPromotion();
        int qty = checkoutProduct.getQty();
        int requireQty = promotion.getRequired_qty();
        BigDecimal promoPrice = promotion.getPrice();

        int qtdPricePromo = qty/(requireQty);

        if (promoPrice != null &&
            checkoutProduct.getProduct() != null &&
            checkoutProduct.getProduct().getPrice() != null)
        {
            BigDecimal priceProductTimes = checkoutProduct.getProduct().getPrice().multiply(new BigDecimal(requireQty));
            BigDecimal dif = priceProductTimes.subtract(promoPrice);
            promoValue = dif.multiply(new BigDecimal(qtdPricePromo));
        }

        return promoValue;
    }
}

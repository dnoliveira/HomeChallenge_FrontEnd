package br.com.nexmuv.homechallenge_frontend.service.promotion;

import br.com.nexmuv.homechallenge_frontend.models.CheckoutProduct;
import br.com.nexmuv.homechallenge_frontend.models.Promotion;
import br.com.nexmuv.homechallenge_frontend.models.PromotionType;

public class PromotionExecuteFactory {

    private static PromotionExecuteBuyxGetyFree promotionExecuteBuyxGetyFree;
    private static PromotionExecuteFlatPercent  promotionExecuteFlatPercent;
    private static PromotionExecuteQtyPriceOverride promotionExecuteQtyPriceOverride;

    public static PromotionExecute getPromotionExecute(PromotionType type){
        PromotionExecute promotionExecute = null;
        if (type == PromotionType.BUY_X_GET_Y_FREE){
            if (promotionExecuteBuyxGetyFree == null){
                promotionExecuteBuyxGetyFree = new PromotionExecuteBuyxGetyFree();
            }
            promotionExecute = promotionExecuteBuyxGetyFree;
        }else if (type == PromotionType.FLAT_PERCENT){
            if (promotionExecuteFlatPercent == null){
                promotionExecuteFlatPercent = new PromotionExecuteFlatPercent();
            }
            promotionExecute = promotionExecuteFlatPercent;
        }else if (type == PromotionType.QTY_BASED_PRICE_OVERRIDE){
            if (promotionExecuteQtyPriceOverride == null){
                promotionExecuteQtyPriceOverride = new PromotionExecuteQtyPriceOverride();
            }
            promotionExecute = promotionExecuteQtyPriceOverride;
        }
        return promotionExecute;
    }

}

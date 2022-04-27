package br.com.nexmuv.homechallenge_frontend.service.promotion;

import br.com.nexmuv.homechallenge_frontend.models.PromotionType;

public class PromotionExecuteFactory {

    public PromotionExecute getPromotionExecute(PromotionType type){
        PromotionExecute promotionExecute = null;
        if (type == PromotionType.BUY_X_GET_Y_FREE){
            promotionExecute = new PromotionExecuteBuyxGetyFree();
        }else if (type == PromotionType.FLAT_PERCENT){
            promotionExecute = new PromotionExecuteFlatPercent();
        }else if (type == PromotionType.QTY_BASED_PRICE_OVERRIDE){
            promotionExecute = new PromotionExecuteQtyPriceOverride();
        }
        return promotionExecute;
    }

}

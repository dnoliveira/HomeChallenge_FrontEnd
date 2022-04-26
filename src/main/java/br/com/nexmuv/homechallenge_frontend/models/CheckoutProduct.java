package br.com.nexmuv.homechallenge_frontend.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class CheckoutProduct {

    private int qty;
    private Product product;
    private Promotion promotion;

    public CheckoutProduct(int qty, Product product){
        this.qty = qty;
        this.product = product;

        List<Promotion> promotionList = product.getPromotions();
        if (promotionList.size() > 0){
            this.promotion = promotionList.get(0);
        }else{
            this.promotion = null;
        }
    }

    public void addQty(){
        this.qty++;
    }

}

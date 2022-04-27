package br.com.nexmuv.homechallenge_frontend.service;

import br.com.nexmuv.homechallenge_frontend.models.*;
import br.com.nexmuv.homechallenge_frontend.service.promotion.PromotionExecute;
import br.com.nexmuv.homechallenge_frontend.service.promotion.PromotionExecuteFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CheckoutService {
    private final Logger log = LoggerFactory.getLogger(CheckoutService.class);

    private Map<String, CheckoutProduct> checkoutProductMapMap = new HashMap<String, CheckoutProduct>();
    private BigDecimal total;
    private BigDecimal totalPromos;
    private BigDecimal totalPayable;

    public Checkout processCheckoutOfBasket(Basket basket){
        //===> Get total
        this.total = basket.getTotal();

        //===> Condense Products
        this.checkoutProductMapMap.clear();
        List<Product> productList = basket.getProductList();
        for (Product p: productList) {
            this.addProduct(p);
        }

        //===> Get total promos for each Condense Products and fill checkoutProductList
        this.totalPromos = new BigDecimal(0.0);
        PromotionExecuteFactory promotionExecuteFactory = new PromotionExecuteFactory();
        Set<String> idProductSet = checkoutProductMapMap.keySet();

        List<CheckoutProduct> checkoutProductList = new ArrayList<CheckoutProduct>();
        for (String idProduct: idProductSet) {
            CheckoutProduct checkoutProduct = checkoutProductMapMap.get(idProduct);

            Promotion promotion = checkoutProduct.getPromotion();
            if (promotion!=null){
                PromotionExecute promotionExecute = PromotionExecuteFactory.getPromotionExecute(promotion.getType());
                BigDecimal promoValue = promotionExecute.execute(checkoutProduct);
                this.totalPromos = this.totalPromos.add(promoValue);
            }

            checkoutProductList.add(checkoutProduct);
        }

        this.totalPayable = this.total.subtract(this.totalPromos);

        //Fill Checkout Object
        Checkout checkout = new Checkout(checkoutProductList, total, totalPromos, totalPayable);
        return checkout;
    }

    private void addProduct(Product product){
        CheckoutProduct checkoutProduct = checkoutProductMapMap.get(product.getId());
        if (checkoutProduct == null){
            checkoutProduct = new CheckoutProduct(1, product);
            checkoutProductMapMap.put(product.getId(), checkoutProduct);
        }else{
            checkoutProduct.addQty();
        }
    }
}

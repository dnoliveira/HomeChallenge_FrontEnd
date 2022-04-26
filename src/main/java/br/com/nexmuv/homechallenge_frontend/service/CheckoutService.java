package br.com.nexmuv.homechallenge_frontend.service;

import br.com.nexmuv.homechallenge_frontend.models.Basket;
import br.com.nexmuv.homechallenge_frontend.models.Checkout;
import br.com.nexmuv.homechallenge_frontend.models.CheckoutProduct;
import br.com.nexmuv.homechallenge_frontend.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            this.add(p);
        }

        //===> Get total promos


        return null;
    }

    private void add(Product product){
        CheckoutProduct checkoutProduct = checkoutProductMapMap.get(product.getId());
        if (checkoutProduct == null){
            checkoutProduct = new CheckoutProduct(0, product);
            checkoutProductMapMap.put(product.getId(), checkoutProduct);
        }else{
            checkoutProduct.addQty();
        }
    }
}

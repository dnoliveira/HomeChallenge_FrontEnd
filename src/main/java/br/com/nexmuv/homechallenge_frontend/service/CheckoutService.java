package br.com.nexmuv.homechallenge_frontend.service;

import br.com.nexmuv.homechallenge_frontend.models.Basket;
import br.com.nexmuv.homechallenge_frontend.models.Checkout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
    private final Logger log = LoggerFactory.getLogger(CheckoutService.class);

    public Checkout processCheckoutOfBasket(Basket basket){
        return null;
    }
}

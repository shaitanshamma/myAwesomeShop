package ru.shaitanshamma.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.shaitanshamma.services.CartService;
import ru.shaitanshamma.services.system.ProductInfo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
public class CartServiceImpl implements CartService {

    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    public Map<ProductInfo, Integer> getCartItems() {
        return cartItems;
    }

    private Map<ProductInfo, Integer> cartItems;

    public CartServiceImpl() {
        cartItems = new ConcurrentHashMap<>();
    }

    @Override
    public void addItemQty(ProductInfo productDot, int qty) {
        cartItems.put(productDot, cartItems.getOrDefault(productDot, 0) + qty);
    }

    @Override
    public void removeItemQty(ProductInfo productDot, int qty) {
        int currentQty = cartItems.getOrDefault(productDot, 0);
        if (currentQty - qty > 0) {
            cartItems.put(productDot, currentQty - qty);
        } else {
            cartItems.remove(productDot);
        }
    }

    @Override
    public void removeItem(ProductInfo productDot) {
        cartItems.remove(productDot);
    }

    @Override
    public Map<ProductInfo, Integer> findAllItems() {
        return Collections.unmodifiableMap(cartItems);
    }

    @Override
    public Integer getItemsQty() {
        return cartItems.size();
    }

    @Override
    public BigDecimal getSubTotal() {
        return cartItems.entrySet().stream()
                .map(e -> e.getKey().getProduct().getPrice().multiply(new BigDecimal(e.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private long created;

    @PostConstruct
    public void postConstruct() {
        created = System.currentTimeMillis();
        logger.info("Session bean created");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("Session bean destroyed {}", (System.currentTimeMillis() - created));
    }
}

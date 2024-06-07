package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.ContentOffering;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }

    public void addToCart(ContentOffering contentOffering, int quantity) {
        Cart cart = new Cart(contentOffering, quantity);
        cartRepository.save(cart);
    }

    public void removeFromCart(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }

    public void clearCart() {
        cartRepository.deleteAll();
    }

    public BigDecimal getTotalPrice() {
        return cartRepository.findAll().stream()
                .map(Cart::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

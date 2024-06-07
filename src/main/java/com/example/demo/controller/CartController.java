package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<Cart> cartItems = cartService.getAllCartItems();
        model.addAttribute("cartItems", cartItems);

        double totalPrice = cartItems.stream()
                                     .mapToDouble(cartItem -> cartItem.getContentOffering().getPrice().doubleValue() * cartItem.getQuantity())
                                     .sum();
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }
}

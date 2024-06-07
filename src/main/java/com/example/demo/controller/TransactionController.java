package com.example.demo.controller;

import com.example.demo.service.CartService;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CartService cartService;

    @PostMapping("/checkout")
    public void checkout() {
        BigDecimal totalPrice = cartService.getTotalPrice();
        transactionService.createTransaction(totalPrice);
        cartService.clearCart();
    }
}

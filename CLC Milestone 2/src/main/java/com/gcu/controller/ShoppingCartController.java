package com.gcu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;
import com.gcu.service.ProductService;
import com.gcu.service.ShoppingCartService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {

 @Autowired
 private ShoppingCartService cartService;

 @Autowired
 private ProductService productService;

 @PostMapping("/shopping-cart/add-to-cart")
 public String addToCart(@RequestParam("productId") Long productId, HttpSession session) {
     ProductModel product = productService.findbyId(productId);
     cartService.addToCart(session, product);
     return "redirect:/";
 }

 @GetMapping("/shopping-cart")
 public String showShoppingCart(Model model, HttpSession session) {
     List<ProductEntity> cartItems = cartService.getCartItems(session);
     model.addAttribute("cartItems", cartItems);
     return "shopping-cart";
 }

 @PostMapping("/shopping-cart/remove-from-cart")
 public String removeFromCart(@RequestParam Long productId, HttpSession session) {
     cartService.removeFromCart(session, productId);
     return "redirect:/";
 }
}

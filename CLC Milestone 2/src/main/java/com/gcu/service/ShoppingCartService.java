package com.gcu.service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {

 public void addToCart(HttpSession session, ProductModel product) {
     List<ProductEntity> cartItems = getOrCreateCart(session);

     ProductEntity cartItem = new ProductEntity();
     cartItem.setProductID(product.getId());
     cartItem.setName(product.getName());
     cartItem.setPrice(product.getPrice());

     cartItems.add(cartItem);
 }

 public List<ProductEntity> getCartItems(HttpSession session) {
     return getOrCreateCart(session);
 }

public void removeFromCart(HttpSession session, long productId) {
  List<ProductEntity> cartItems = getOrCreateCart(session);

  cartItems.removeIf(item -> item.getProductID() == productId);
}

 private List<ProductEntity> getOrCreateCart(HttpSession session) {
     @SuppressWarnings("unchecked")
	List<ProductEntity> cartItems = (List<ProductEntity>) session.getAttribute("cart");

     if (cartItems == null) {
         cartItems = new ArrayList<>();
         session.setAttribute("cart", cartItems);
     }

     return cartItems;
 }
}

package com.example.kiosk.controller;

import com.example.kiosk.dto.cart.AddCartItemRequest;
import com.example.kiosk.dto.cart.CartDto;
import com.example.kiosk.dto.cart.CartItemDto;
import com.example.kiosk.service.CartService;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartApiController {
    private final CartService cartService;
    public static final String Cart_Session_Key = "cart";
    @PostMapping("/api/cart")
    public ResponseEntity<CartDto> addCart(@RequestBody AddCartItemRequest request, HttpSession httpSession) {
        CartDto cartDto = cartService.addCartItem(request, httpSession);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cartDto);
    }

    @GetMapping("/api/cart")
    public ResponseEntity<CartDto> cartList(HttpSession session) {
        CartDto cartDto = (CartDto) session.getAttribute(Cart_Session_Key);
        if(cartDto == null) {
            return null;
        }

        return ResponseEntity.ok()
                .body(cartDto);
    }

    @DeleteMapping("api/cart")
    public ResponseEntity<Void> deleteCart(HttpSession session) {
        session.removeAttribute(Cart_Session_Key);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("api/cart/{index}")
    public ResponseEntity<CartDto> deleteCartItem(@PathVariable(name = "index") int index, HttpSession session) {
        CartDto cartDto = cartService.deleteCartItem(index, session);

        return ResponseEntity.ok().build();
    }

}

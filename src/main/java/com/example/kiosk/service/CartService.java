package com.example.kiosk.service;

import com.example.kiosk.controller.CartApiController;
import com.example.kiosk.dto.cart.AddCartItemRequest;
import com.example.kiosk.dto.cart.CartDto;
import com.example.kiosk.dto.cart.CartItemDto;
import com.example.kiosk.dto.cart.UpdateCartItemRequest;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartService {
    private final String session_Key = CartApiController.Cart_Session_Key;

    public CartDto addCartItem(AddCartItemRequest request, HttpSession httpSession) {
        CartDto cartDto = (CartDto) httpSession.getAttribute(session_Key);

        CartItemDto cartItemDto = request.toEntity();
        cartItemDto.totalPriceCalc();

        if(cartDto == null) { // 장바구니가 없으면 새로 생성하고 상품 추가
            List<CartItemDto> newCart = new ArrayList<>();
            newCart.add(cartItemDto);
            cartDto = new CartDto(cartItemDto.getTotalPrice(), newCart);
        } else { // 기존 장바구니가 존재할 때
            List<CartItemDto> existCartItems = cartDto.getCartItems();
            BigDecimal existCartTotal = cartDto.getCartTotalPrice();

            cartDto.setCartTotalPrice(existCartTotal.add(cartItemDto.getTotalPrice()));
            if(existCartItems.contains(cartItemDto)) { // 이미 장바구니에 존재하는 메뉴일 때
                int index = existCartItems.indexOf(cartItemDto);
                int amount = cartItemDto.getAmount();

                CartItemDto existedItem = existCartItems.get(index);
                int newAmount = existedItem.getAmount() + amount;

                existedItem.setAmount(newAmount);
                existedItem.totalPriceCalc();
                existCartItems.set(index, existedItem);
            } else {
                existCartItems.add(cartItemDto);
            }
        }

        httpSession.setAttribute(session_Key, cartDto);

        return cartDto;
    }

    public CartDto deleteCartItem(int index, HttpSession httpSession) {
        CartDto cartDto = (CartDto) httpSession.getAttribute(session_Key);
        List<CartItemDto> cartItems = cartDto.getCartItems();

        BigDecimal cartTotal = cartDto.getCartTotalPrice();
        BigDecimal deleteItemPrice = cartItems.get(index).getTotalPrice();

        cartItems.remove(index);

        if(cartItems.size() == 0) {
            httpSession.removeAttribute(session_Key);
            return null;
        }

        BigDecimal newCartTotal = cartTotal.subtract(deleteItemPrice);
        cartDto.setCartTotalPrice(newCartTotal);

        return cartDto;
    }

    public CartDto updateAmountCartItem(int index, UpdateCartItemRequest request, HttpSession httpSession) {
        CartDto cartDto = (CartDto) httpSession.getAttribute(session_Key);
        List<CartItemDto> cartItems = cartDto.getCartItems();
        CartItemDto cartItem = cartItems.get(index);

        int newAmount = cartItem.getAmount() + request.getAmount();

        if(newAmount <= 0) {
            return deleteCartItem(index, httpSession);
        }

        BigDecimal singleItemPrice = cartItem.getTotalPrice().divide(BigDecimal.valueOf(cartItem.getAmount())); // 개 당 가격
        BigDecimal newPrice = singleItemPrice
                .multiply(BigDecimal.valueOf(request.getAmount()))
                .add(cartDto.getCartTotalPrice());

        cartItem.setAmount(newAmount);
        cartItem.totalPriceCalc();

        cartDto.setCartTotalPrice(newPrice);

        return cartDto;
    }
}

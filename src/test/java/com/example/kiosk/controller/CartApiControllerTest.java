package com.example.kiosk.controller;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.kiosk.dto.cart.AddCartItemRequest;
import com.example.kiosk.dto.cart.CartDto;
import com.example.kiosk.dto.cart.CartItemDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class CartApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected MockHttpSession session;
    @Autowired
    private WebApplicationContext context;

    @Autowired
    protected ObjectMapper objectMapper;

    @BeforeEach
    public void SetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        this.session = new MockHttpSession();
    }

    @Test
    @DisplayName("addCartItem: 새 상품 추가에 성공한다")
    public void addCartItemTest_new() throws Exception {
        //given
        final String url = "/api/cart";
        final Long menuId = 1L;
        final String menuName = "test";
        final BigDecimal menuPrice = BigDecimal.valueOf(1000);
        final int amount = 1;

        final AddCartItemRequest request = AddCartItemRequest.builder()
                .menuId(menuId)
                .menuName(menuName)
                .menuPrice(menuPrice)
                .amount(amount)
                .build();

        final String requestBody = objectMapper.writeValueAsString(request);

        //when
        ResultActions result = mockMvc.perform(post(url)
                        .session(session)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        //then

        result.andExpect(status().isCreated());

        CartDto cartDto = (CartDto) session.getAttribute("cart");
        assertThat(cartDto.getCartItems().get(0).getMenuId()).isEqualTo(menuId);
        assertThat(cartDto.getCartItems().get(0).getMenuName()).isEqualTo(menuName);
        assertThat(cartDto.getCartItems().get(0).getMenuPrice()).isEqualTo(menuPrice);
        assertThat(cartDto.getCartItems().get(0).getAmount()).isEqualTo(amount);

    }

    @Test
    @DisplayName("addCartItem: 존재하는 상품일 경우 수량을 1 늘린다")
    public void addCartItemTest_exist() throws Exception {
        //given
        final String url = "/api/cart";
        final Long menuId = 1L;
        final String menuName = "test";
        final BigDecimal menuPrice = BigDecimal.valueOf(1000);
        final Long[] optionId = {1L};
        final String[] optionName = {"testOption"};
        final BigDecimal[] optionPrice = {BigDecimal.valueOf(500)};
        final int amount = 1;

        final AddCartItemRequest request = AddCartItemRequest.builder()
                .menuId(menuId)
                .menuName(menuName)
                .menuPrice(menuPrice)
                .optionId(optionId)
                .optionName(optionName)
                .optionPrice(optionPrice)
                .amount(amount)
                .build();

        final String requestBody = objectMapper.writeValueAsString(request);

        CartItemDto cartItemDto = request.toEntity();
        cartItemDto.totalPriceCalc();

        List<CartItemDto> cartItemDtos = new ArrayList<>();

        cartItemDtos.add(cartItemDto);
        CartDto cartDto = new CartDto(cartItemDto.getTotalPrice(), cartItemDtos);
        session.setAttribute("cart", cartDto);

        //when
        ResultActions result = mockMvc.perform(post(url)
                .session(session)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        //then
        CartDto updatedCart = (CartDto) session.getAttribute("cart");

        assertThat(updatedCart.getCartTotalPrice()).isEqualTo(BigDecimal.valueOf(3000));
        assertThat(updatedCart.getCartItems().size()).isEqualTo(1);
        assertThat(updatedCart.getCartItems().get(0).getAmount()).isEqualTo(2);
    }
}

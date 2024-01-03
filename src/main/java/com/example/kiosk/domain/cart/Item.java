package com.example.kiosk.domain.cart;

import com.example.kiosk.domain.menu.Menu;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne // 하나의 장바구니에는 여러 아이템을 담을 수 있으므로
    @JoinColumn(name="cart_id")
    private Cart cartId;

    @OneToOne
    @JoinColumn(name = "menu_id")
    private Menu menuId;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Builder
    public Item(Cart cartId, Menu menuId, int amount) {
        this.cartId = cartId;
        this.menuId = menuId;
        this.amount = amount;
    }

    /*public void update(int amount) {
        this.amount = amount;
    }*/
}

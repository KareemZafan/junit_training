package org.iti.mobile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ShoppingCartTests {

    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp(){
        shoppingCart = new ShoppingCart();
    }

    @Test
    void testAddingItemToShoppingCart() {
        shoppingCart.addItems(List.of(new Item("LG Screen", "1234"), new Item("SAMSUNG Tablet S6", "MobilePhone-23334")));
        assertFalse(shoppingCart.getItems().isEmpty());
        assertEquals(2, shoppingCart.getItems().size());
        assertEquals(List.of("LG Screen", "SAMSUNG Tablet S6"),
                shoppingCart.getItems().stream().map(item -> item.getName()).collect(Collectors.toList()));
    }

    @Test
    void testRemoveItemsFromShoppingCart() {
        shoppingCart.addItems(List.of(new Item("LG Screen", "1234"), new Item("SAMSUNG Tablet S6", "MobilePhone-23334"),
                new Item("Playstation5", "PL_9342349u")));
        assertFalse(shoppingCart.getItems().isEmpty());
        shoppingCart.removeItems(List.of("1234", "MobilePhone-23334"));
        assertEquals(List.of("Playstation5"),
                shoppingCart.getItems().stream().map(item -> item.getName()).collect(Collectors.toList()));
    }

}


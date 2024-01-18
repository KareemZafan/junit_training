package org.iti.mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<Item> shoppingList;
    private long capacity;
    private double totalPrice;

    public ShoppingCart() {
        shoppingList = new ArrayList<>();
    }

    public ShoppingCart(List<Item> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<Item> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Item> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addItems(List<Item> items) {
        shoppingList.addAll(items);
    }

    public List<Item> getItems() {
        return shoppingList;
    }

    public void removeItems(List<String> ids) {
        shoppingList.removeAll(shoppingList.stream().filter(item->ids.contains(item.getId())).collect(Collectors.toList()));
    }
}

package com.tutorial.webservices.model;

import com.tutorial.webservices.model.dto.CartDto;
import com.tutorial.webservices.model.dto.ItemDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="cart_id")
    private List<Item> items = new ArrayList<>();

    public Cart(){}

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static Cart from(CartDto cartDto){
        Cart cart = new Cart();
        cart.setName(cartDto.getName());
        return cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package com.tutorial.webservices.service;

import com.tutorial.webservices.model.Cart;
import com.tutorial.webservices.model.Item;
import com.tutorial.webservices.model.exception.CartNotFoundException;
import com.tutorial.webservices.model.exception.ItemIsAlreadyAssingnedException;
import com.tutorial.webservices.model.exception.ItemNotFoundException;
import com.tutorial.webservices.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class CartService {
    private CartRepository cartRepository;
    private ItemService itemService;

    @Autowired
    public CartService(CartRepository cartRepository, ItemService itemService) {
        this.cartRepository = cartRepository;
        this.itemService = itemService;
    }

    public Cart addCart(Cart cart){
        return cartRepository.save(cart);
    }

    public List<Cart> getCarts(){
        return StreamSupport
                .stream(cartRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Cart getCart(Long id){
        return cartRepository.findById(id).orElseThrow(() ->
                new CartNotFoundException(id));
    }

    public Cart deleteCart(Long id){
        Cart cart = getCart(id); //making sure that the item are in the DB
        cartRepository.delete(cart);
        return cart;
    }

    @Transactional
    public Cart editCart(Long id, Cart  cart){
        Cart cartToEdit = getCart(id);
        cartToEdit.setName(cart.getName());
        return cartToEdit;
    }

    @Transactional
    public Cart addItemToCart(Long cardId, Long itemId){
        Cart cart = getCart(cardId);
        Item item = itemService.getItem(itemId);
        if(Objects.nonNull(item.getCart())){
            throw new ItemIsAlreadyAssingnedException(itemId,item.getCart().getId());
        }
        cart.addItem(item);
        return cart;
    }

    @Transactional
    public Cart removeItemFromCart(Long cardId, Long itemId){
        Cart cart = getCart(cardId);
        Item item = itemService.getItem(itemId);
        cart.removeItem(item);
        return cart;
    }


}

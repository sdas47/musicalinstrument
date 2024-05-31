package com.example.service;

import com.example.model.CartItem;
import com.example.model.Instrument;
import com.example.repository.CartItemsRepository;
import com.example.repository.InstrumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemsService {
    @Autowired
    private CartItemsRepository cartItemsRepository;
    @Autowired
    private InstrumentRepository instrumentRepository;

    public Long addToCart(Instrument instrument) {
        CartItem cartItem = CartItem.builder()
                .name(instrument.getName())
                .price(instrument.getPrice())
                .instrumentId(instrument.getId())
                .build();
        cartItem = cartItemsRepository.save(cartItem);
        return cartItem.getId();
    }

    public List<Instrument> getCartItems() {
        List<Instrument> instruments = new ArrayList<>();
        List<CartItem> cartItems = cartItemsRepository.findAll();
        for(CartItem cartItem : cartItems) {
            instruments.add(cartItem.getInstrument());
        }
        return instruments;
    }

    public void deleteAll() {
        cartItemsRepository.deleteAll();
    }

    public void deleteItem(CartItem cartItem) {
        cartItemsRepository.delete(cartItem);
    }

    public Optional<CartItem> findById(Long id) {
        return cartItemsRepository.findByInstrumentId(id);
    }
}

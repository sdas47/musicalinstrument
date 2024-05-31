package com.example.controller;

import com.example.model.CartItem;
import com.example.model.Instrument;
import com.example.repository.InstrumentRepository;
import com.example.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class InstrumentController {

    @Autowired
    private InstrumentRepository instrumentRepository;
    @Autowired
    private CartItemsService cartItemsService;

    @GetMapping("/instruments")
    List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    @PostMapping("/cart")
    ResponseEntity<Long> addInstrumentToCart(@RequestBody Instrument instrument) {
        List<Instrument> latestCartItems = cartItemsService.getCartItems();
        if(latestCartItems.stream().filter(item->item.getId().equals(instrument.getId())).count()>0) {
            return new ResponseEntity<>(instrument.getId(), HttpStatus.CONFLICT);
        }
        else {
            long cartId = cartItemsService.addToCart(instrument);
            return new ResponseEntity<>(cartId, HttpStatus.CREATED);
        }
    }

    @GetMapping("/cart")
    List<Instrument> getAllCartItems() {
        return cartItemsService.getCartItems();
    }

    @DeleteMapping("/cart")
    ResponseEntity<String> deleteAllCartItems() {
        cartItemsService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cart/{id}")
    Instrument deleteSingleItem(@PathVariable("id") Long id) {
        Optional<CartItem> product = cartItemsService.findById(id);
        if(product.isPresent()) {
            cartItemsService.deleteItem(product.get());
            return product.get().getInstrument();
        }
        return new Instrument();
    }
}

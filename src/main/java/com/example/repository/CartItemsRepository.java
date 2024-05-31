package com.example.repository;

import com.example.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemsRepository extends JpaRepository<CartItem, Long> {

    /**
     * @param id of instrument
     * @return The Cart Item which is to be removed
     */
    public Optional<CartItem> findByInstrumentId(Long id);
}

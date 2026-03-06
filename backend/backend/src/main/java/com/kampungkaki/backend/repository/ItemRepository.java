package com.kampungkaki.backend.repository;

import com.kampungkaki.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // That's it! JpaRepository provides all the CRUD methods automatically.
}
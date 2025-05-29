package ru.itmo.s312198.devops.market.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByOwner(Long owner);
}
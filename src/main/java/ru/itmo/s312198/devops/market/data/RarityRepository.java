package ru.itmo.s312198.devops.market.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RarityRepository extends JpaRepository<Rarity, Integer> {
    Rarity findByRarity(String rarity);
}
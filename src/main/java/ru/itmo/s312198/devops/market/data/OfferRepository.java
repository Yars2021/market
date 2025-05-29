package ru.itmo.s312198.devops.market.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
    List<Offer> findBySalesman(Long salesman);
    List<Offer> findByBuyer(Long buyer);
    List<Offer> findByStatus(Integer status);
}
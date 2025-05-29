package ru.itmo.s312198.devops.market.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    Status findByStatus(String status);
}
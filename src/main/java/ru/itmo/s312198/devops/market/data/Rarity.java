package ru.itmo.s312198.devops.market.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rarities")
public class Rarity {
    @Id
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String rarity;

    public Rarity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rarity(Integer rid, String rarity) {
        this.id = rid;
        this.rarity = rarity;
    }


    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity_name) {
        this.rarity = rarity_name;
    }
}
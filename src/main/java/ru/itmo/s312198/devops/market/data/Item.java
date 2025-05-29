package ru.itmo.s312198.devops.market.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genItems")
    @SequenceGenerator(name = "genItems", sequenceName = "seq_items", allocationSize = 1)
    @Column(unique = true, nullable = false)
    Long id;

    @Column(nullable = false)
    private Integer type;

    @Column(nullable = false, length = 64)
    private Long owner;

    @Column(nullable = false, length = 256)
    private String name;

    @Column(nullable = false)
    private Integer rarity;

    @Column(length = 1024)
    private String description;

    @ManyToMany(mappedBy = "items")
    private Set<Offer> offers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Item() {
    }

    public Item(Integer type, Long owner, String name, Integer rarity, String description) {
        this.type = type;
        this.owner = owner;
        this.name = name;
        this.rarity = rarity;
        this.description = description;
    }
}

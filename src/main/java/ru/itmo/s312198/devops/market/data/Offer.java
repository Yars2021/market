package ru.itmo.s312198.devops.market.data;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqOffer")
    @SequenceGenerator(name="seqOffer", sequenceName="seq_offer", allocationSize=1)
    private Integer id;

    @Column(nullable = false)
    private Long salesman;

    @Column
    private Long buyer;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String published;

    @Column(nullable = false)
    private Integer status;

    @ManyToMany
    @JoinTable(
            name = "offer_item",
            joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> items;

    public Offer() {
    }

    public Offer(Long salesman, Long buyer, Integer price, String published, Integer status) {
        this.salesman = salesman;
        this.buyer = buyer;
        this.price = price;
        this.published = published;
        this.status = status;
    }

    public Offer(Integer id, Long salesman, Long buyer, Integer price, String published, Integer status) {
        this.id = id;
        this.salesman = salesman;
        this.buyer = buyer;
        this.price = price;
        this.published = published;
        this.status = status;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSalesman() {
        return salesman;
    }

    public void setSalesman(Long salesman) {
        this.salesman = salesman;
    }

    public Long getBuyer() {
        return buyer;
    }

    public void setBuyer(Long buyer) {
        this.buyer = buyer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
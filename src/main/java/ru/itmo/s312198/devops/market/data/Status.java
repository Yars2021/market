package ru.itmo.s312198.devops.market.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String status;

    public Status() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status(Integer sid, String status) {
        this.id = sid;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status_name) {
        this.status = status_name;
    }
}
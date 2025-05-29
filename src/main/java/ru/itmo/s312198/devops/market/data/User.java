package ru.itmo.s312198.devops.market.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genUsers")
    @SequenceGenerator(name = "genUsers", sequenceName = "seq_users", allocationSize = 1)
    @Column(unique = true, nullable = false)
    Long id;

/*
    @NotBlank(message = "Login is required")
    @Size(min = 3, max = 20, message = "Login should be between 3 and 20 characters")
*/
    @Column(unique = true, nullable = false)
    String login;

/*
    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 35, message = "Password should be between 6 and 35 characters")
*/
    @Column(nullable = false)
    String password;

/*
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Login should be between 3 and 50 characters")
*/
    @Column(nullable = false)
    String name;

/*
    @NotBlank(message = "Balance is required")
*/
    @Column(nullable = false)
    Long balance;

/*
    @NotBlank(message = "Seller reputation is required")
*/
    @Column(nullable = false)
    Integer reputationSeller;

/*
    @NotBlank(message = "Buyer reputation")
*/
    @Column(nullable = false)
    Integer reputationBuyer;

    public User() {
    }

    public User(String login, String password, String name, Long balance, Integer reputationSeller, Integer reputationBuyer) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.balance = balance;
        this.reputationSeller = reputationSeller;
        this.reputationBuyer = reputationBuyer;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Integer getReputationSeller() {
        return reputationSeller;
    }

    public void setReputationSeller(Integer reputationSeller) {
        this.reputationSeller = reputationSeller;
    }

    public Integer getReputationBuyer() {
        return reputationBuyer;
    }

    public void setReputationBuyer(Integer reputationBuyer) {
        this.reputationBuyer = reputationBuyer;
    }
}

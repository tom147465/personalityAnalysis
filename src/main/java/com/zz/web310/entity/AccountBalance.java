package com.zz.web310.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import javax.persistence.*;


@Entity
@Table(name = "account_balance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalance {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "balance")
    private BigDecimal balance;
}
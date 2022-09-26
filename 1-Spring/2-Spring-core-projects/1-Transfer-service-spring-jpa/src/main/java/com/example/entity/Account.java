package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
/*
JPA is a ORM framework for we need to 1st.
Mark this one as the entity.
And every entity must have the primary key mapping.
 */
public class Account {

    @Id
    @Column(length = 12)
    private String number;
    private double balance;

}

package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
//we can enable now setters and getters methods using one of the dependency which is called Lombok
import lombok.NoArgsConstructor;

@Data
/*
So the moment I use this data annotation I will get set and get methods for
these two fields and the two string method as well
 */
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private  String number;
    private  double balance;
}

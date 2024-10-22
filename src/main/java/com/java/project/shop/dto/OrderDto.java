package com.java.project.shop.dto;

import com.java.project.shop.entities.Client;
import com.java.project.shop.entities.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {

    Long id;
    Boolean isPaid;
    Client client;
    Set<Product> products;

}

package com.java.project.shop.services;

import com.java.project.shop.entities.BlackList;
import com.java.project.shop.entities.Client;

import java.util.List;

public interface BlackListService {

    List<BlackList> save(Client client);

    List<BlackList> findAll();

}

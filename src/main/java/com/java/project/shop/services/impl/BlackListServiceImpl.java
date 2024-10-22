package com.java.project.shop.services.impl;

import com.java.project.shop.entities.BlackList;
import com.java.project.shop.entities.Client;
import com.java.project.shop.repositories.BlackListRepository;
import com.java.project.shop.services.BlackListService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BlackListServiceImpl implements BlackListService {

    BlackListRepository blackListRepository;

    @Override
    @Transactional
    public List<BlackList> save(Client client) {
        var blackList = new BlackList();
        blackList.setClient(client);
        blackListRepository.save(blackList);
        return findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlackList> findAll() {
        return blackListRepository.findAll();
    }

}

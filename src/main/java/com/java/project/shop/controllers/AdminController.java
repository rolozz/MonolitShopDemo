package com.java.project.shop.controllers;

import com.java.project.shop.dto.ProductDto;
import com.java.project.shop.entities.BlackList;
import com.java.project.shop.entities.Client;
import com.java.project.shop.services.BlackListService;
import com.java.project.shop.services.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AdminController {

    ProductService productService;
    BlackListService blackListService;

    @PostMapping("/admin/save")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.save(productDto));
    }

    @PutMapping("/admin/ban")
    public ResponseEntity<List<BlackList>> ban(@RequestBody Client client) {
        blackListService.save(client);
        return ResponseEntity.ok(blackListService.findAll());
    }

}

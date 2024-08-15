package org.example.jwtauth.Controller;

import org.example.jwtauth.DTO.ProductDTO;
import org.example.jwtauth.Models.Product;
import org.example.jwtauth.Service.ProductService;
import org.example.jwtauth.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private Service service;

    @PostMapping()
    public ResponseEntity createProduct(@RequestBody ProductDTO productDTO)
    {

        Product product = service.createProduct(productDTO);
        return ResponseEntity.ok(product);
    }

    @GetMapping()
    public ResponseEntity getAllProducts()
    {
        List<Product> allProducts = service.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping("/example")
    public ResponseEntity request(@RequestHeader("Authorization") String header)
    {
        String username = service.getUsernameFromHeader(header);
        return ResponseEntity.ok(username);
    }


}

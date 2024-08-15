package org.example.jwtauth.Service;

import org.example.jwtauth.DTO.ProductDTO;
import org.example.jwtauth.Models.Product;

import java.util.List;

public interface Service {

    Product createProduct(ProductDTO productDTO);

    List<Product> getAllProducts();


    String getUsernameFromHeader(String header);
}

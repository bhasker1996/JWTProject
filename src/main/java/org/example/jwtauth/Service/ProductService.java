package org.example.jwtauth.Service;

import org.example.jwtauth.DTO.ProductDTO;
import org.example.jwtauth.Models.Product;
import org.example.jwtauth.Repository.ProductRepository;
import org.example.jwtauth.Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

@org.springframework.stereotype.Service
public class ProductService implements Service{

    private ProductRepository productRepository;
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    public ProductService(ProductRepository productRepository, JwtTokenProvider jwtTokenProvider) {
        this.productRepository = productRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {

        Product product = new Product();

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> all = productRepository.findAll();
        return all;
    }

    @Override
    public String getUsernameFromHeader(String header) {

        String bearerToken = header;
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer "))
        {
            String token = bearerToken.substring(7, bearerToken.length());
            String username = null;
            if(StringUtils.hasText(token) && jwtTokenProvider.validatedToken(token)) {
                //get username from token

                username = jwtTokenProvider.getUsername(token);
            }
            return username;
        }
        return null;
    }

}

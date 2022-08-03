package com.example.thi__eadddd.service;

import com.example.thi__eadddd.entity.Product;
import com.example.thi__eadddd.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
        final ProductRepository productRepository;

        public Product save(Product product) {
                return productRepository.save(product);
        }
        public Page<Product> findAll(int page, int limit){
                return productRepository.findAll(
                        PageRequest.of(page-1, limit, SpringDataWebProperties.Sort.Direction.ASC,"id"));
        }
        public Optional<Product> findById(Long id) {
                return productRepository.findById(id);
        }
        public void deleteById(Long id) {
                productRepository.deleteById(id);
        }

}

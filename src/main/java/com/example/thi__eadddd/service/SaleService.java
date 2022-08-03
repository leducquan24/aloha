package com.example.thi__eadddd.service;

import com.example.thi__eadddd.entity.Sale;
import com.example.thi__eadddd.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {
    final SaleRepository saleRepository;

    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }
    public Page<Sale> findAll(int page, int limit){
        return saleRepository.findAll(
                PageRequest.of(page-1, limit, Sort.Direction.ASC,"id"));
    }
    public Optional<Sale> findById(Long id) {
        return saleRepository.findById(id);
    }
    public void deleteById(Long id) {
        saleRepository.deleteById(id);
    }
}

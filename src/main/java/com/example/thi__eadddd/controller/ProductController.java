package com.example.thi__eadddd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    final ProductService productService;
    @Autowired
    SaleRepository saleRepository;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> processSaveCategory(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(path = "list" , method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "page",defaultValue = "1") int page,
                          @RequestParam(value = "limit",defaultValue = "10")int limit,
                          Model model){
        model.addAttribute("Pageable",productService.findAll(page, limit));
        return "view/sales/list";
    }
    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Product existProduct= optionalProduct.get();
        existProduct.setProductName(product.getProductName());
        return ResponseEntity.ok(productService.save(existProduct));
    }
}

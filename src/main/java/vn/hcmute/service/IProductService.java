package vn.hcmute.service;

import vn.hcmute.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product save(Product product);

    Product get(Long id);

    void delete(Long id);
}

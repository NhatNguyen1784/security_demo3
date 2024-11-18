package vn.hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hcmute.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

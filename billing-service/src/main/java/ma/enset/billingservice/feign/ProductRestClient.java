package ma.enset.billingservice.feign;

import ma.enset.billingservice.dtos.Product;
import ma.enset.billingservice.entities.ProductItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductRestClient {
    @GetMapping("/api/products/{id}")
    ProductItem getProductById(@PathVariable String id);


    @GetMapping("/api/products/")
    PagedModel<Product> getAllProducts();
}

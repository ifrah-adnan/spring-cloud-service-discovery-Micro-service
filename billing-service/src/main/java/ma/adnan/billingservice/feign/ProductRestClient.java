package ma.adnan.billingservice.feign;

import ma.adnan.billingservice.dto.Customer;
import ma.adnan.billingservice.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/products/{id}")
    Product findProductByID(@PathVariable String id);
    @GetMapping("/products")
    PagedModel<Product> allProduct();
}

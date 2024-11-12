package ma.adnan.billingservice.web;

import ma.adnan.billingservice.dto.Customer;
import ma.adnan.billingservice.dto.Product;
import ma.adnan.billingservice.entities.Bill;
import ma.adnan.billingservice.entities.ProductItem;
import ma.adnan.billingservice.feign.CustomerRestClient;
import ma.adnan.billingservice.feign.ProductRestClient;
import ma.adnan.billingservice.repository.BillRepository;
import ma.adnan.billingservice.repository.ProductItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@RestController
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }
    @GetMapping("/tst1/{id}")

    public Bill getBill(@PathVariable Long id){
        Bill bill=billRepository.findById(id).orElseThrow();
        Customer customer=customerRestClient.findCustomerByID(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(productItem -> {
            Product product=productRestClient.findProductByID(productItem.getProductId());
            productItem.setProduct(product);
        });
        return bill;

    }
}

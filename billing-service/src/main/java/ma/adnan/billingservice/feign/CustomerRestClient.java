package ma.adnan.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.adnan.billingservice.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "CustomerServiceCB",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerByID(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name = "CustomerServiceCB",fallbackMethod = "getDefaultCustomers")
    PagedModel<Customer> getAllCustomers();
    default Customer getDefaultCustomer(Long id,Exception e){
        return Customer.builder().id(id).name("Default name").email("Default email").build();


    }
    default PagedModel<Customer> getDefaultCustomers(Exception e){
        return PagedModel.empty();
    }
}

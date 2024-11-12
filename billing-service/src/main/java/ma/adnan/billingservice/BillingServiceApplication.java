package ma.adnan.billingservice;

import ma.adnan.billingservice.dto.Customer;
import ma.adnan.billingservice.dto.Product;
import ma.adnan.billingservice.entities.Bill;
import ma.adnan.billingservice.entities.ProductItem;
import ma.adnan.billingservice.feign.CustomerRestClient;
import ma.adnan.billingservice.feign.ProductRestClient;
import ma.adnan.billingservice.repository.BillRepository;
import ma.adnan.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient){

		return  args -> {
			Collection<Customer> customers= customerRestClient.getAllCustomers().getContent();
			Collection<Product> products=productRestClient.allProduct().getContent();
			customers.forEach(customer -> {
				Bill bill= Bill.builder()
						.billingDate(new Date())
						.customerId(customer.getId())
						.build();
				billRepository.save(bill);
				products.forEach(product -> {
					System.out.println("get all product"+product.getId());


					ProductItem productItem= ProductItem.builder()
							.bill(bill)
							.productId(product.getId())
							.unitPrice(product.getPrice())
							.quantity(1+new Random().nextInt())
							.build();

					productItemRepository.save(productItem);
				});
			});
		};

}
}

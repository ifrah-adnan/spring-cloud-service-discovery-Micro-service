package ma.adnan.inventoryservice;

import ma.adnan.inventoryservice.entities.Product;
import ma.adnan.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("phone").price(1200).quantity(20).build());
			productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("TV").price(8000).quantity(10).build());
			productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Laptop").price(13000).quantity(3).build());

			productRepository.findAll().forEach(p->{
				System.out.println("------------------");
				System.out.println(p.getId());
				System.out.println(p.getName());
				System.out.println(p.getPrice());
				System.out.println(p.getQuantity());
				System.out.println("---------------------");
			});
		};
}
}

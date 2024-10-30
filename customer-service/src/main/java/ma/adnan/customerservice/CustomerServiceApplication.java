package ma.adnan.customerservice;

import ma.adnan.customerservice.entities.Customer;
import ma.adnan.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@SpringBootApplication
public class CustomerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class,args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder().name("adnan").email("adnan@gmail.com").build());
			customerRepository.save(Customer.builder().name("imad").email("imad@gmail.com").build());
			customerRepository.save(Customer.builder().name("ahmed").email("ahmed@gmail.com").build());

			customerRepository.findAll().forEach(c->{
				System.out.println("================");
				System.out.println(c.getId());
				System.out.println(c.getName());
				System.out.println(c.getEmail());
				System.out.println("====================");

			});
		};
	}
}

package ma.adnan.customerservice.repositories;

import ma.adnan.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

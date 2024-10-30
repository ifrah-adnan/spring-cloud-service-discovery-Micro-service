package ma.adnan.inventoryservice.repository;

import ma.adnan.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,String> {
}

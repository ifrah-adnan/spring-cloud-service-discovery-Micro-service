package ma.adnan.billingservice.repository;

import ma.adnan.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
public interface BillRepository extends JpaRepository<Bill,Long> {
}

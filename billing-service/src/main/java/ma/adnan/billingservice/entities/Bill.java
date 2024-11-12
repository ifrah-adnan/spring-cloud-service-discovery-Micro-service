package ma.adnan.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.adnan.billingservice.dto.Customer;

import java.util.Date;
import java.util.List;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder

public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private Date billingDate;
    private long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}

package ma.adnan.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@Projection(name = "p1",types = Customer.class)
public interface CustomerProjection {
    String getName();
}

package ma.adnan.billingservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@Getter @Setter
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}

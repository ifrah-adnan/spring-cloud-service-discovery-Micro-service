package ma.adnan.billingservice.dto;

import lombok.*;

/**
 * @author Dell Latitude 5420
 * IFRAH ADNAN
 **/
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;

}

package miu.edu.CourseRegistration1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String street;
    private String city;
    private String postalCode;
    private  String stateProvince;
    private String countryRegion;

    public Address(String street, String city, String postalCode, String stateProvince, String countryRegion) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.stateProvince = stateProvince;
        this.countryRegion = countryRegion;
    }
}

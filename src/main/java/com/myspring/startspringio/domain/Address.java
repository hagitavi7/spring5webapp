package com.myspring.startspringio.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@Entity
public class Address {
    @Id
    private Long id;

    private String name;
    private String line1;
    private String city;
    private String zip;
    private String country;

    @ManyToOne
    private Publisher publisher;

    public Address() {
    }

    public Address(String name, String line1, String city, String zip, String country) {
        this.name = name;
        this.line1 = line1;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return (name != null && zip != null) ? (name.equals(address.getName()) && zip.equals(address.getZip())) : address.getName() == null && address.getZip() == null;
        //return Objects.equals(name, address.name) && Objects.equals(zip, address.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, zip);
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", line1='" + line1 + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

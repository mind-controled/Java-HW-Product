package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, int price, String name, String manufacturer) {
        super(id, price, name);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || this.getManufacturer().matches(search);
    }
}
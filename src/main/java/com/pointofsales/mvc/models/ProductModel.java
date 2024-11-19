package com.pointofsales.mvc.models;

import org.springframework.web.bind.annotation.ModelAttribute;

public class ProductModel {
    private final int id;
    private final String name;
    private final double salePrice;
    private final double unitCost;

    public ProductModel() {
        id = 0;
        name = "";
        salePrice = 0.0;
        unitCost = 0.0;
    }

    public ProductModel(int id, String name, double salePrice, double unitCost) {
        this.id = id;
        this.name = name;
        this.salePrice = salePrice;
        this.unitCost = unitCost;
    }

    @ModelAttribute("id")
    public int getId() {
        return id;
    }

    @ModelAttribute("name")
    public String getName() {
        return name;
    }

    @ModelAttribute("salePrice")
    public double getSalePrice() {
        return salePrice;
    }

    @ModelAttribute("unitCost")
    public double getUnitCost() {
        return unitCost;
    }

    @ModelAttribute("markup")
    public double getMarkup() {
        // Markup Percentage = (Selling Price - Cost) / Cost x 100
        return (salePrice - unitCost) / unitCost * 100;
    }
}

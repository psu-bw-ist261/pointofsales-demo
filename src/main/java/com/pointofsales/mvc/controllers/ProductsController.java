package com.pointofsales.mvc.controllers;

import com.pointofsales.mvc.models.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class ProductsController {

    @PostMapping("/products/")
    public String createProduct(@ModelAttribute ProductModel productModel) {
        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable int id, Model model) {
        ProductModel productModel = switch (id) {
            case 1 -> new ProductModel(1, "Widget", 1.0, 0.5);
            case 2 -> new ProductModel(2, "Stem Bolt", 3.0, 1.5);
            case 3 -> new ProductModel(3, "Stem Bolt", 6.0, 0.5);
            case 4 -> new ProductModel(4, "Cookie Jar", 10, 3);
            case 5 -> new ProductModel(5, "Phone Charger", 8, 2.86);
            case 6 -> new ProductModel(6, "White Board Eraser", 2.5, 0.73);
            case 7 -> new ProductModel(7, "Hair Tie", 1.5, 0.33);
            case 8 -> new ProductModel(8, "Clamp", 34.25, 19.34);
            default -> throw new ResponseStatusException(NOT_FOUND, "Unable to find the specified product");
        };

        model.addAttribute("product", productModel);

        return "products/edit";
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<ProductModel> products = new ArrayList<>();

        products.add(new ProductModel(1, "Widget", 1.0, 0.5));
        products.add(new ProductModel(2, "Stem Bolt", 3.0, 1.5));
        products.add(new ProductModel(3, "Stem Bolt", 6.0, 0.5));
        products.add(new ProductModel(4, "Cookie Jar", 10, 3));
        products.add(new ProductModel(5, "Phone Charger", 8, 2.86));
        products.add(new ProductModel(6, "White Board Eraser", 2.5, 0.73));
        products.add(new ProductModel(7, "Hair Tie", 1.5, 0.33));
        products.add(new ProductModel(8, "Clamp", 34.25, 19.34));

        model.addAttribute("products", products);

        return "products/list";
    }

    @GetMapping("/products/")
    public String newProduct(Model model) {
        ProductModel productModel = new ProductModel();

        model.addAttribute("product", productModel);

        return "products/add";
    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable int id, @ModelAttribute ProductModel productModel) {
        return "redirect:/products";
    }
}
